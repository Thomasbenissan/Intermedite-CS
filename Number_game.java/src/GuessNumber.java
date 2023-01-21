import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

//Thomas Benissan 2022

public class GuessNumber {
  public static void main(String[] args) throws Exception {
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    int randomNumber = rand.nextInt(100) + 1; //create random num for user to guess

    File Highscores;
    Highscores = new File("Highscores.txt"); // create new file
    if (Highscores.createNewFile()) { // if the createNewFile function returns true -> the file doesn't exist
      System.out.println("New Highscores file created in this files directory!");
    } else {
      System.out
          .println("Each new Highscore can be found in the Highscores.txt file in the same directory as this file"); //retiterate where the file can be found
    }

    int userGuess; //create a variable for the users guess
    int guesses = 0; // set the guesses to 0
    int attempt = 0; // set attempts to 0

    ArrayList<Integer> nums_guessed = new ArrayList<>();

    System.out.println("Guess a number from 1 to 100");
    while (attempt < 5) { // Run the loop while the user hasn't used all 5 attempts
      userGuess = ErrorChecking.errorCheck(scan); // Set the user guess to the input they give while checking to make
                                                  // sure
      // the input is a num between 1 and 100 through the errorCheck method

      if (nums_guessed.contains(userGuess)) { //if the guess is in the list of previously guessed nums
        System.out.println("You've already guess this number, did not count as a guess. Try Again");
        continue; //restart the loop
      } else {
        System.out.println("Yay! This is what I expected");
        guesses += 1; // increase the number of guesses by 1
        nums_guessed.add(userGuess); //add the guess to the numbers the user has guessed
      }

      if (userGuess > randomNumber) { // if the users number is greater than the number
        System.out.println("Your guess is higher than the number. \nGuess again! \n\n");

      } else if (userGuess < randomNumber) { // if the users number is lower than the number
        System.out.println("Your guess is lower than the number. \nGuess again! \n\n");

      } else { // if its not lower or higher it is the correct number

        System.out.println("Congratulations, you guessed the right number! \n You guessed the correct number in "
            + guesses + " guesses!"); // tell the user how many guesses they needed, and that they wont the game
        attempt += 1; // add 1 attempt
        checkHighscore.isHighscore(Highscores, guesses); // check if its a highscore
        guesses = 0; // reset guesses to 0
        randomNumber = rand.nextInt(100) + 1; // rechoose a ranodm int
        nums_guessed.removeAll(nums_guessed); // remove all the previously guessed numbers
        if(attempt!= 5){ // if its not the end of the last round
          System.out.println(
            "Round " + (attempt + 1) + "\n You have " + (5 - attempt) + " attemps left to beat your highscore"); // print
        // which
        // attempt
        // the
        // user
        // is
        // on
        }
        

      }
    }
  }
}
