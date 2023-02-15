
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

  static int max;
  static int randomNumber;
  static Random rand = new Random();
  static Scanner sc = new Scanner(System.in);
  static boolean keepPlaying = true;
  static File Highscores;
  

  public static void main(String[] args) throws Exception {
    
    Highscores = new File("Highscores.txt"); // create new file
    if (Highscores.createNewFile()) { // if the createNewFile function returns true -> the file doesn't exist
      System.out.println("New Highscores file created in this files directory!");
    } else {
      System.out
          .println("Each new Highscore can be found in the Highscores.txt file in the same directory as this file"); // retiterate where the file can be found
    }

  
    while (keepPlaying) {
      System.out.println("Enter the number corresponding to the desired difficulty: ");
      System.out.println("1. Easy (Max: 10)");
      System.out.println("2. Medium (Max: 20)");
      System.out.println("3. Hard (Max: 50)");
      System.out.println("4. Very Hard (Max: 100)");
      System.out.println("5. Insane (Max: 200)");
      String choseDifficulty = sc.nextLine();
      int chosenDifficulty;
      try {
        chosenDifficulty = Integer.parseInt(choseDifficulty);
      } catch (Exception e) {
        System.out.println("This is not a number between 1 and 5 \nTry again");
        continue;
      }


      if (!(chosenDifficulty > 0 && chosenDifficulty < 6)) {
        System.out.println("This is not a number between 1 and 5 \n");
        continue;
      }
      switch (chosenDifficulty) {
        case 1:
          max = 10;
          randomNumber = rand.nextInt(max) + 1;
          new Game(max, randomNumber, Highscores);
          break;

        case 2:
          max = 20;
          randomNumber = rand.nextInt(max) + 1;
          new Game(max, randomNumber, Highscores);
          break;

        case 3:
          max = 50;
          randomNumber = rand.nextInt(max) + 1;
          new Game(max, randomNumber, Highscores);
          break;

        case 4:
          max = 100;
          randomNumber = rand.nextInt(max) + 1;
          new Game(max, randomNumber, Highscores);
          break;
        case 5:
          max = 200;
          randomNumber = rand.nextInt(max) + 1;
          new Game(max, randomNumber, Highscores);
          break;

      }
      sc.nextLine(); // dispose last enter 
      System.out.println("Woud you like to play again press [y] or [n]");
      if (sc.nextLine() == "y") {
        continue;
      } else {
        keepPlaying = false;
        System.out.println("Thanks for playing");
      }
    }
  }
}