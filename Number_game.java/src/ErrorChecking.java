import java.util.Scanner;

public class ErrorChecking {

    public static int rangeCheck(Scanner sc, boolean minOrMax) {
        int min = 0; // I needed to set min to something because otherwise it would give me an error,
                     // however min will always be what the user chooses due to the error checking
        int max;
        
        if (minOrMax) { // error checking for min when true
            System.out.println("Input a number for the minimum value of the range");
            if (sc.hasNextInt()) {
                min = sc.nextInt();
                System.out.println("This is a valid input");
                return min;
            } else {
                System.out.println("This is not a number \nTry Again");
                rangeCheck(sc, true);

            }
        } else { // error checking for max when false
            System.out.println("Input a number for the maximum value of the range");
            if (sc.hasNextInt()) {
                max = sc.nextInt();
                System.out.print(max);
                if (min < max) {
                    System.out.println("Great the range you selected was " + min + " - " + max);
                    return max;
                }else {
                    System.out.println(
                            "Both inputs were valid however the minimun was greater than the maximun, \nInput a new maximum");
                    rangeCheck(sc, false); // recheck the max by setting the boolean as false
                }

            }else{
                System.out.println("This is not a number, \nTry Again");
                rangeCheck(sc, false);
            } 
        }
        return 0;
    }

    public static int errorCheck(Scanner sc, int min, int max) {

        System.out.println("I am expecting a number from " + min + " to " + max);

        if (sc.hasNextInt()) {
            int input = sc.nextInt();
            if (input > max || input < min) { // if the number is not in between max and min (exclusive) print error
                                              // message
                                              // that this was not the correct number
                System.out.println("Hey! this number is not in your specified range. \nTry again.");
                return errorCheck(sc, min, max); // it did not pass the error check, reiterate through the method (with
                                                 // the next
                // input)
            } else { // if the number is in between min and max (inclusive) print happy message

                return input;
            }
        } else { // in the case that teh input is not a number print message adressing the
                 // problem that the input was not a number
            System.out.println("This is not a number. Discarding this input");
            sc.next(); // discarding the next input
            return errorCheck(sc, min, max); // it did not pass the error check, reiterate through the method (with the
                                             // next
            // input)
        }
    }
}