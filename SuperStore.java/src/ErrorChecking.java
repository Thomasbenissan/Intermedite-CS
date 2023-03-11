import java.util.ArrayList;
import java.util.Scanner;

//ask about scanner and next line and how to discard something so that sc.nextLine works in confirmAction   

public class ErrorChecking {

    static Scanner sc = new Scanner(System.in);
    
    public static int buyOrSell(String num, ArrayList<Item> userItems) {
       
        
        // Check if the string has only the int 1 in it
        if (num.equals("1")) {
            System.out.println("Great lets get to buying a stock");
            return 1;
        }
        
        // Check if the string has only the int 2 in it
        if (num.equals("2") && userItems.isEmpty()) {
            System.out.println("Great lets get to selling a stock!");
            return 2;
        }
        
        // If none of the above conditions are true, return false
        return 0;
    }

    public static int buyStock(Item[] stocks, int userBalance){

        System.out.println("Which stock would you like to buy \nEnter the name of the stock you would like to buy as it is shown \nEx.('DogeCoin')");
        
       
        String name = sc.nextLine();
        for(Item item: stocks){
            if(item.name.equals(name)){
                System.out.println("How many shares of " + item.name + " would you like to buy \nEnter an integer ex.'7'");

                
                if(sc.hasNextInt()){ //error checking for user input to make sure they enter a valid amount
                    int amount = sc.nextInt();
                    if(amount * item.price <= userBalance){
                        if(!confirmAction(0, amount, item)){
                            System.out.println("You did not confirm if you wanted to buy the shares. \nTry again");
                            buyStock(stocks, userBalance);
                            break;
                        }
                        System.out.println("Great you bought "+ amount + " shares of " + item.name + " at - $" + item.price);
                        return item.price * amount;
                    }else{
                        buyStock(stocks, userBalance);
                    }
                    
                }else{
                    System.out.println("You did not enter an Integer, Try again");
                    buyStock(stocks, userBalance);
                }
                
            }
        }
        System.out.println("You did type the name correctly try again\n");
        buyStock(stocks, userBalance);

        return 0;
    }

    public static int sellStock(Item[] stocks, int userBalance){


        System.out.println("Which stock would you like to sell \nEnter the name of the stock you would like to sell as it is shown \nEx.('DogeCoin')");
        
       
        String name = sc.nextLine();
        for(Item item: stocks){
            if(item.name.equals(name)){
                System.out.println("How many shares of" + item.name + "would you like to sell \nEnter an integer ex.'7'");

                
                if(sc.hasNextInt()){ //error checking for user input to make sure they enter a valid amount
                    int amount = sc.nextInt();
                    if(amount <= item.amountOwned){
                        if(!confirmAction(1, amount, item)){
                            System.out.println("You did not confirm if you wanted to sell the shares. \nTry again");
                            sellStock(stocks, userBalance);
                            break;
                        }
                        System.out.print("Selling " + amount + "shares of " + item.name);
                        return item.price * amount;
                    }else{
                        System.out.println("You do not have enough shares to sell\nYou only have " + item.amountOwned + " shares\nTry again");
                
                        sellStock(stocks, userBalance);
                    }
                    
                }else{
                    System.out.println("You did not enter an integer, Try again");
                    sellStock(stocks, userBalance);
                }
                
            }
        }
        System.out.println("You did type the name correctly try again\n");
        sellStock(stocks, userBalance);

        return 0;
    }

    public static boolean confirmAction(int buyOrSell, int amount, Item item){
        sc.nextLine();
        String input = sc.nextLine();

        if(buyOrSell == 0){
            System.out.println("Are you sure you want to buy " + amount + " shares of " + item.name + "\nIt will cost you $" + amount * item.price + "\nPress [y] to confirm, anything else with deny the purchase");
            if(input.equals("y")){
                return true;
            }

        }else{
            System.out.println("Are you sure you want to sell " + amount + " shares of " + item.name + "\nYou will receive $" + amount * item.price + "\nPress [y] to confirm, anything else with deny the sale");
            if(input.equals("y")){
                return true;
            }
        }

        return false;
    }

    
   

    public static boolean keepPlaying(int userBalance){
        System.out.println("\nWould you like to keep playing \n[y] if would like to keep playing \n[n] if not");
        sc.nextLine(); // reverting back to lines

        String choice = sc.nextLine();

        if(choice.equals("y")){

            System.out.println("Great, onto the next trading day");
            return true;

        }else if(choice.equals("n")){ //stop playing

            System.out.println("Thanks for playing your final balance was $" + userBalance);

            if(userBalance - 1000000 > 0){
                System.out.println("You made $" + (userBalance - 1000000));
                return false;
            }else{
                System.out.println("You lost $" + -(userBalance - 1000000));
                return false;
            }
            
        }else{

            System.out.println("You did not type either [y] or [n]\nTry again");
            return keepPlaying(userBalance);
        }
    }
}
