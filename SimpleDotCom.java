import java.util.ArrayList;

public class SimpleDotCom {
    int numOfHits = 0;
    ArrayList<Integer> locationCells;  
    ArrayList<Integer> guessedCells;   

 
    public void setLocationCells(ArrayList<Integer> locs) {
        locationCells = locs;
        guessedCells = new ArrayList<>();  
    }



    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "мимо";
        
        if (!guessedCells.contains(guess)) {
            guessedCells.add(guess);
        }
        else {
            return "Эта клетка уже была угадана";
        }

        if (locationCells.contains(guess)) {
            numOfHits++;
            int index = locationCells.indexOf(guess);
            locationCells.remove(index);  
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
        
        
        ArrayList<Integer> locations = new ArrayList<>();
        int randomNum = (int) (Math.random() * 5);
        for (int i = randomNum; i < randomNum + 3; i++) {
            locations.add(i);  
        }
        
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
