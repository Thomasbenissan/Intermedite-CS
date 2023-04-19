import java.util.ArrayList;
import java.util.Scanner;

  

public class Store {

    static Scanner sc = new Scanner(System.in);
    
    public static int buyOrSell(String num, ArrayList<Item> userItems) {
       
        
        // Check if the string has only the int 1 in it
        if (num.equals("1")) {
            System.out.println("Great lets get to buying a stock");
            return 1;
        }
        
        // Check if the string has only the int 2 in it
        if (num.equals("2")) {
            return 2;
        }
        
        // If none of the above conditions are true, return false
        return 0;
    }

    public static int buyStock(Item[] stocks, int userBalance, ArrayList<Item> userItems){
        //check that the user has enough money to buy the cheapest stock
        int cheapest = Integer.MAX_VALUE;
        for(Item stock : stocks){
            if(stock.price < cheapest){
                cheapest = stock.price;
            }
        }
        if(cheapest > userBalance){
            System.out.println("You do not have enough money to buy any stock \nYou must sell first");
            return -sellStock(stocks, userBalance, userItems); //return the negative value of sell stock since return value willl be subtracted from userBalance --> return value will be added to userBalance
            
        }

        // Display prompt for user to enter stock name
        System.out.println("Which stock would you like to buy? \nEnter the name of the stock you would like to buy as it is shown \nEx.('DogeCoin')");
        String name = sc.nextLine();

        // Search for the stock by name
        for (Item item : stocks) {
            if (item.name.equals(name)) {
                // Display prompt for user to enter amount of shares to buy
                System.out.println("How many shares of " + item.name + " would you like to buy?");
                int amount = getPositiveIntInput();

                if(amount == 0){ //if they did not enter an int that passes error checkign
                    System.out.println("That was not a positive integer \nTry again");
                    return buyStock(stocks, userBalance, userItems);
                    
                }

                // Check if user can afford the purchase
                int cost = item.price * amount;
                if (cost > userBalance) {
                    System.out.println("You cannot buy that many shares. You do not have enough money. \n You have $"+ userBalance +" Try again");
                    return buyStock(stocks, userBalance, userItems);
                }

                // Confirm the purchase with the user
                if (!confirmAction(0, amount, item)) {
                    System.out.println("You did not confirm if you wanted to buy the shares. \nTry again");
                    return buyStock(stocks, userBalance, userItems);
                }

                // Update amount owned of the stock and add the stock to user items
                item.amountOwned += amount;
                userItems.add(item);
                System.out.println("You bought " + amount + " shares of " + item.name + " at $ " + item.price + " per share.");
                return cost;
            }
        }
        System.out.println("The stock you entered does not exist. \nTry again");
        return buyStock(stocks, userBalance, userItems);
    }


 // Finds an Item in an array of Items by name
 // Returns null if the item is not found

public static Item findItemByName(Item[] items, String name) {
    for (Item item : items) {
        if (item.name.equals(name)) {
            return item;
        }
    }
    return null;
}

//error checks user input for buying
public static int getPositiveIntInput() {
    int amount = 0;

    try {
        amount = Integer.parseInt(sc.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter an integer.");
        return 0;
    }

    if (amount <= 0) {
        System.out.println("Invalid input. Please enter a positive integer.");
        return 0;
    }

    return amount;
}

    public static int sellStock(Item[] stocks, int userBalance, ArrayList<Item> userItems){
            // Print out user's owned stocks and their values
        System.out.println("Here is a list of all your owned stocks, how many you have, and their value:");
        userItems.forEach(item -> System.out.println(item.name + " " + item.amountOwned + " $" + item.amountOwned * item.price));

        // Get stock name from user input
        System.out.println("Which stock would you like to sell?\nEnter the name of the stock you would like to sell as it is shown (e.g., 'DogeCoin'):");
        String name = sc.nextLine();

        // Find the selected stock
        for (Item item : stocks) {
            if (item.name.equals(name)) {
                // Get the amount of shares to sell from user input
                System.out.println("How many shares of " + item.name + " would you like to sell?\nEnter an integer (e.g., '7'):");

                int amount = 0;
                if (sc.hasNextInt()) {
                    amount = sc.nextInt();
                } else {
                    System.out.println("You did not enter an integer, try again.");
                    return sellStock(stocks, userBalance, userItems);
                }

                // Check if the user has enough shares to sell
                if(amount > item.amountOwned){
                    System.out.println("You do not have enough shares to sell. You only have " + item.amountOwned + " shares. Try again.");
                    return sellStock(stocks, userBalance, userItems);
                }

                // Confirm the action with the user
                sc.nextLine();// clear the line from the sc.hasNextInt
                if(!confirmAction(1, amount, item)){
                    System.out.println("You did not confirm if you wanted to sell the shares. Try again.");
                    return sellStock(stocks, userBalance, userItems);
                }

                // Calculate and print the amount of money earned from selling the shares
                int earnings = item.price * amount;
                System.out.print("Selling " + amount + " shares of " + item.name + ". You earned $" + earnings);

                // Update user balance and the selected stock's amountOwned
                userBalance += earnings;
                item.amountOwned -= amount;

                //check to see if stock needs to be removed from userItems

                if(item.amountOwned == 0){
                    userItems.remove(item);
                }
                return earnings;
                
            } 
        }

        System.out.println("You did not type the name correctly, try again.");
        return sellStock(stocks, userBalance, userItems);
    }

   
    public static boolean confirmAction(int buyOrSell, int amount, Item item){
        String input; 


        if(buyOrSell == 0){
            System.out.println("Are you sure you want to buy " + amount + " shares of " + item.name + "\nIt will cost you $" + amount * item.price + "\nPress [y] to confirm, anything else will deny the purchase");
            input = sc.nextLine();
            if(input.equals("y")){
                return true;
            }

        }else{
            System.out.println("Are you sure you want to sell " + amount + " shares of " + item.name + "\nYou will receive $" + amount * item.price + "\nPress [y] to confirm, anything else will deny the sale");
            input = sc.nextLine();
            if(input.equals("y")){
            
                return true;
            }
        }

        return false;
    }

    
   

    public static boolean keepPlaying(int userBalance){
        System.out.println("\nWould you like to keep playing \n[y] if would like to keep playing \n[n] if not");


        String choice = sc.nextLine();

        if(choice.equals("y")){

            System.out.println("Great, onto the next trading day \nToday's Balance : " + userBalance);
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
