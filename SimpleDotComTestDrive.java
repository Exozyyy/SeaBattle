public class SimpleDotComTestDrive {
  public static void main(String[] args) {
      SimpleDotCom dot = new SimpleDotCom();
      int[] locations = {2, 3, 4};  // Инициализация расположения ячеек
      dot.setLocationCells(locations);  // Устанавливаем расположение ячеек
      String userGuess = "4";  // Пример догадки пользователя
      String result = dot.checkYourself(userGuess);  // Проверяем угадывание
      System.out.println(result);  // Печатаем результат
  }
}
