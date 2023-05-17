package BuzzFeedQuiz;
//I don't know what copyrighting my name means so I just put my name at the top of each file
//By Thomas Benissan
import java.util.Scanner;

import GamePortal.Game;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Thomas_Quiz implements Game{
    static String finalAnswer;
    public static void main(String[] args) throws Exception {

        // Attach Answers to Questions
        Question q1 = new Question("After a long day, what's your favorite dinner meal?");
        q1.possibleAnswers[0] = new Answer("A restaurant Paella", 1);
        q1.possibleAnswers[1] = new Answer("A nice juicy Burger", 2);
        q1.possibleAnswers[2] = new Answer("A Big tomahawk steak", 3);

        Question q2 = new Question("On a vacation where is your ideal spot?");
        q2.possibleAnswers[0] = new Answer("Greece on the beaches", 1);
        q2.possibleAnswers[1] = new Answer("Colorado in the mountains", 2);
        q2.possibleAnswers[2] = new Answer("Rome for some sight seeing", 3);

        Question q3 = new Question("How do you put toothpaste on your toothbrush?");
        q3.possibleAnswers[0] = new Answer("First water then toothpaste then more water", 1);
        q3.possibleAnswers[1] = new Answer("Just toothpaste then water", 2);
        q3.possibleAnswers[2] = new Answer("I don't brush my teeth", 3);

        Question q4 = new Question("Whats your favorite social media?");
        q4.possibleAnswers[0] = new Answer("Bereal", 1);
        q4.possibleAnswers[1] = new Answer("Instagram", 2);
        q4.possibleAnswers[2] = new Answer("Tiktok", 3);

        Question q5 = new Question("What word best describes yourself?");
        q5.possibleAnswers[0] = new Answer("Calm", 1);
        q5.possibleAnswers[1] = new Answer("Extroverted", 2);
        q5.possibleAnswers[2] = new Answer("A mix of both", 3);

        // For each question, ask, read input, store answer.
        Scanner sc = new Scanner(System.in);
        gameIntro(sc);
        int finalPoints = 0; // set the total points that determine the Answer to the quiz to 0
        Question[] qArray = { q1, q2, q3, q4, q5 };
        List<Question> qList = Arrays.asList(qArray); // convert qArray to list to be able to shuffle it
        Collections.shuffle(qList); // shuffle qList so that the questions are in a random order
        for (Question q : qList) {
            finalPoints += q.ask(sc); // ask question while setting the points it returns to finalPoints
        }
        // based on the number of points find the final answer,
        // finalAnswer depends on total quantity of points attributed to each answer
        // chosen

        finalAnswer = getAnswer(finalPoints); // set final answer to the sanwer corresponding ot the number of
                                                     // points which is figured out in the getAnswer method
        System.out.println(
                "According to your personality, if you were a soccer player, you would be " + finalAnswer + "!");

    }

    public static void gameIntro(Scanner sc) {
        // requires 1 to keep going
        System.out.println("What soccer player does your personality correspond to?");
        System.out.println("You get to choose numbers 1-4 for every question. Enter '1' to play!");
        String play = sc.next();
        if (!play.equals("1")) { // if the next line that the scanner takes as input, even if it is a string, is
                                 // not '1' re iterate through the gameIntro method
            System.out.println("Unidentifiable input. Please enter '1' to play");
            gameIntro(sc); // reiterate gameIntro method
        }
    }

    public static String getAnswer(int points) {
        String finalAnswer;

        if (points < 8) { // if the points from answers chosen add up to less than five (exclusive)
            finalAnswer = "Kylian Mbappe";
        } else if (points > 7 && points < 11) { // if the points from answers chosen add up to a number in betwen 4 and 9
                                               // (exclusive)
            finalAnswer = "Lionel Messi";
        } else { // if the points from asnwers chosen add up to a number greater than 8
                 // (exclusive)
            finalAnswer = "Cristiano Ronaldo";
        }
        return (finalAnswer);
    }

    @Override
    public String getGameName() {
      // TODO Auto-generated method stub
      return "BuzzFeed Quiz!";
    }
  
  
    @Override
    public void play() {
      try {
        Thomas_Quiz.main(null);
    } catch (Exception e) {
      }
    }
  
  
    @Override
    public String getScore() {
      return finalAnswer;
    }
  
  
   
}



