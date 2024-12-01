import java.util.ArrayList;

public class SimpleDotCom {
    int numOfHits = 0;
    ArrayList<String> locationCells;
    ArrayList<String> guessedCells;

    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
        guessedCells = new ArrayList<>();
    }

    public String checkYourself(String stringGuess) {
        String result = "мимо";
        
        if (guessedCells.contains(stringGuess)) {
            return "Эта клетка уже была угадана";
        } else {
            guessedCells.add(stringGuess);
        }

        if (locationCells.contains(stringGuess)) {
            numOfHits++;
            locationCells.remove(stringGuess);  // Удаляем угаданную клетку
            result = "попал";
        }

        if (locationCells.isEmpty()) {
            result = "потопил";

        }
        return result;
    }

    public static void main(String[] args) {
        GameHelper helper = new GameHelper();
        SimpleDotCom theDotCom = new SimpleDotCom();

        String[][] playArea = new String[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                playArea[i][j] = "[]";
            }
        }

        ArrayList<String> locations = new ArrayList<>();
        int randomRow = (int) (Math.random() * 7);
        int randomColumn = (int) (Math.random() * 5); 
        for (int i = 0; i < 3; i++) {
            String cell = randomRow + "," + (randomColumn + i);
            locations.add(cell);
            playArea[randomRow][randomColumn + i] = " X"; 
        }
        theDotCom.setLocationCells(locations);

        int numOfGuesses = 0;
        boolean isAlive = true;

        while (isAlive) {
            System.out.println("Поле для игры:");
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    System.out.print(playArea[i][j]);
                }
                System.out.println();
            }
            String guess = helper.getUserInput("введите число  ");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;
            System.out.println(result);
            if (result.equals("потопил")) {
                isAlive = false;
                System.out.println("Вам потребовалось " + numOfGuesses + " попыток(и)");
            }
        }
    }
}
