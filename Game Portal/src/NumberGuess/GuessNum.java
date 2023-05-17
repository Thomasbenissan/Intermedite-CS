package NumberGuess;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

//Thomas Benissan 2022

public class GuessNum {

  Scanner scan = new Scanner(System.in);
  int userGuess; // create a variable for the users guess
  int guesses = 0; // set the guesses to 0
  boolean correct;

  ArrayList<Integer> nums_guessed = new ArrayList<>();

  GuessNum(int max, int randomNumber, File Highscores) throws Exception {
    
   
    while(!correct){
      System.out.println("Guess a number from " + 0 + " to " + max);
      // Run the loop while the user hasn't used all 5 attempts
      userGuess = ErrorChecking.errorCheck(scan, 0, max); // Set the user guess to the input they give while checking
                                                          // to make
      // sure
      // the input is a num between min and max through the errorCheck method

      if (nums_guessed.contains(userGuess)) { // if the guess is in the list of previously guessed nums
        System.out.println("You've already guess this number, did not count as a guess. Try Again");

      } else {
        System.out.println("Yay! This is what I expected");
        guesses += 1; // increase the number of guesses by 1
        nums_guessed.add(userGuess); // add the guess to the numbers the user has guessed
      }

      if (userGuess > randomNumber) { // if the users number is greater than the number
        System.out.println("Your guess is higher than the number. \nGuess again! \n\n");

      } else if (userGuess < randomNumber) { // if the users number is lower than the number
        System.out.println("Your guess is lower than the number. \nGuess again! \n\n");

      } else { // if its not lower or higher it is the correct number

        System.out.println("Congratulations, you guessed the right number! \n You guessed the correct number in "
            + guesses + " guesses!"); // tell the user how many guesses they needed, and that they wont the game
          correct = true;

        checkHighscore.isHighscore(Highscores, guesses); // check if its a highscore
        guesses = 0; // reset guesses to 0
        nums_guessed.removeAll(nums_guessed); // remove all the previously guessed numbers

      
      }
    } 
  }
}
