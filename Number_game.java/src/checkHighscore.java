import java.io.*;
import java.util.*;

public class checkHighscore {

    public static boolean isHighscore(File Highscores, int guesses) throws Exception {

        ArrayList<Integer> prevHighscores = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new FileReader(Highscores)); // create a new file reader
        String line;

        if (Highscores.length() != 0) { // if the file is not empty
            while ((line = reader.readLine()) != null) { // set the line string to the next line
                int num = Integer.parseInt(line); // parse the string to get the integer, set num equal to that
                prevHighscores.add(num); // add that num to an arraylist of previous highscores
            }

            reader.close();

            int min = prevHighscores.get(0);

            for (int guess : prevHighscores) { // find the lowest highscore, aka the most recent highscore, aka the best
                                               // highscore
                if (guess < min) {
                    min = guess;
                }
            }

            if (guesses < min) { // if the user guess is less than the best highscore
                New_Highscore(Highscores, guesses, prevHighscores);// pass the Hischores file, the number of guesses,
                                                                   // and the previous highscores to the NewHighscore
                                                                   // method so that it can put the highscore in the
                                                                   // Highscore file
                System.out.println("This is a new Highscore! Recorded in the Highscores.txt file");
                return true;

            } else { // if the usre guess is not less than the best highscore
                System.out.println("This is not a new highscore, Try again");
                return false;
            }
        } else { // if the file is empty any number of guesses will be a new highscore
            New_Highscore(Highscores, guesses, prevHighscores); // pass the Hischores file, the number of guesses, and
                                                                // the previous highscores to the NewHighscore method so
                                                                // that it can put the highscore in the Highscore file
            System.out.println("This is a new Highscore! Recorded in the Highscores.txt file");
            reader.close();
            return true;
        }

    }

    public static void New_Highscore(File Highscores, int guesses, ArrayList<Integer> previousHighscores)
            throws Exception {
        // write to the file
        BufferedWriter writer = new BufferedWriter(new FileWriter(Highscores)); //create a new file writer
        String guesses2 = Integer.toString(guesses); // change the highscore guess int to string so that the writer can put it in the Hischores file
        for (int highscore : previousHighscores) { //reprint all the previous highscores, to make sure the file keeps them instead of overwiting them
            writer.write(highscore + "\n"); //write each highscore and a new line
        }
        writer.write(guesses2 + "\n"); // at the end of the file write the new highscore the user just got
        writer.close(); //close the writer

    }

}
