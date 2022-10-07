import java.util.Scanner;  

class App {
  public static void main(String[] args) {
    Scanner obj = new Scanner(System.in); 
    System.out.println("What is your name?");

    String userName = obj.nextLine();  
    System.out.println("Hi " + userName); 

    
    System.out.println("What is your favorite Ice cream flavor" );
    String flavor = obj.nextLine();
    System.out.println("How many scoops of ice cream do you want? (Use a number)" );
    int scoops = obj.nextInt();
    

    boolean iseven = scoops % 2 == 0;
    System.out.println("You want " + scoops + " scoops!");

    if (iseven == true) {
        System.out.println("That is an even number of scoops");
    }
    else {
        System.out.println("That is an odd number of scoops");
    }
    

    

  }
}