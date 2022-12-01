import java.util.Scanner; 

public class ErrorChecking {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        errorCheck(sc);
    }

    public static int errorCheck(Scanner sc) {
        System.out.println("I am expecting a number from 1 - 3!");
        
        if(sc.hasNextInt()) {
            int input = sc.nextInt();
            System.out.println("This is a number");
            if (input > 3 || input < 1) { //if the number is not in between 1 and 3(inclusive) print error message that this was not the correct number
                System.out.println("Hey! this number is not what I wanted. Try again.");
                return errorCheck(sc); //it did not pass the error check, reiterate through the method (with the next input) 
            } else { // if the number is in between 1 and 3 (inclusive) print happy message
                System.out.println("Yay! This is what I expected");
                return input;
            }
        } else { //in the case that teh input is not a number print message adressing the problem that the input was not a number
            System.out.println("This is not a number. Discarding this input");
            sc.next(); // discarding the next input
            return errorCheck(sc); //it did not pass the error check, reiterate through the method (with the next input) 
        }
    }
}