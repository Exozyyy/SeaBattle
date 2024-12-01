public class SimpleDotCom {
    int numOfHits = 0;
    int[] locationCells;
    public void setLocationCells(int[] locs) {
      locationCells = locs;
    }
    public String checkYourself(String stringGuess) {
      int guess = Integer.parseInt(stringGuess);
      String result = "мимо";
      for (int cell : locationCells) {
        if (guess == cell) {
          numOfHits++;
          result = "попал";
          break;
        }
      }
  
      if (numOfHits == locationCells.length) {
        result = "выиграл";
      }
      return result;
    }
    public static void main(String[] args) {
      GameHelper helper = new GameHelper();
      SimpleDotCom theDotCom = new SimpleDotCom();
      int randomNum = (int) (Math.random() * 5);
      int[] locations = {randomNum, randomNum + 1, randomNum + 2};
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
  