import java.util.ArrayList;

public class SimpleDotCom {
    int numOfHits = 0;
    ArrayList<Integer> locationCells; 
    ArrayList<Integer> guessedCells;   

    public void setLocationCells(int[] locs) {
        locationCells = new ArrayList<>();
        for (int loc : locs) {
            locationCells.add(loc);  
        }
        guessedCells = new ArrayList<>();  
    }

    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "мимо";
        if (guessedCells.contains(guess)) {
            return "Эта клетка уже была угадана";
        }
        guessedCells.add(guess);  
        if (locationCells.contains(guess)) {
            numOfHits++;
            locationCells.remove(Integer.valueOf(guess)); // Убираем угаданную клетку из списка
            result = "попал";
        }
        if (locationCells.isEmpty()) {
            result = "выиграл";
        }
        return result;
    }
    public static void main(String[] args) {
        GameHelper helper = new GameHelper();
        SimpleDotCom theDotCom = new SimpleDotCom();
        int randomNum = (int) (Math.random() * 5);
        int[] locations = {randomNum, randomNum + 1, randomNum + 2}; // Генерация случайных координат
        theDotCom.setLocationCells(locations);
        int numOfGuesses = 0;
        boolean isAlive = true;
        while (isAlive) {
            String guess = helper.getUserInput("введите число");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;
            System.out.println(result);
            if (result.equals("выиграл")) {
                isAlive = false;
                System.out.println("Вам потребовалось " + numOfGuesses + " попыток(и)");
            }
        }
    }
}
