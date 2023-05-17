package BuzzFeedQuiz;
//By Thomas Benissan
import java.util.Scanner;

public class Question {
    // Fields
    String label;
    int points;
    Answer[] possibleAnswers = new Answer[3]; // Each question has 3 answers

    Question(String label) {
        this.label = label;
    }

    int ask(Scanner sc) {
        System.out.println(this.label);
        // prints out all the answer choices
        for (int i = 0; i < this.possibleAnswers.length; i++) {
            String choice = Integer.toString(i + 1);
            System.out.println("[" + choice + "]:" +
                    this.possibleAnswers[i].label);
        }
        
        int ans = ErrorChecking.errorCheck(sc);//makes sure that the answer passes the errorCheck method and sets ans to what errorCheck returns
                                                //In the case that the answer fails teh error check the errorCheck method reasks the question
        return  possibleAnswers[ans - 1].points;
    }

}