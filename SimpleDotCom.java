public class SimpleDotCom {
  int[] locationCells;
  int numOfHits = 0;

  // Устанавливаем расположение ячеек
  public void setLocationCells(int[] locs) {
      locationCells = locs;
  }

  // Проверяем ответ пользователя
  public String checkYourself(String stringGuess) {
      int guess = Integer.parseInt(stringGuess);  // Преобразуем строку в число
      String result = "мимо";  // Изначально считаем, что попадания нет

      // Перебираем ячейки
      for (int cell : locationCells) {
          if (guess == cell) {
              numOfHits++;
              result = "попал";  // Если угадали
              break;  // Если угадали, больше не проверяем
          }
      }

      // Если все ячейки были угаданы
      if (numOfHits == locationCells.length) {
          result = "выиграл";  // Если все попадания совершены, игра окончена
      }

      return result;  // Возвращаем результат
  }
}
