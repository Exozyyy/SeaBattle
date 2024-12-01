public class SimpleDotCom {
  int[] locationCells;
  int numOfHits = 0;
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
}
