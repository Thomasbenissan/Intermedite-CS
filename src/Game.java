import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    
    static ArrayList<Item> userItems = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int userBalance = 1000000;
    static boolean keepPlaying = true;
    static boolean day1 = true;

    static Item[] stocks = new Item[10];

        

    
    public static void main(String[] args) throws Exception {

        //all the possible stocks
        stocks[0] = new carItem("Ferrari", 20000, 0);
        stocks[1] = new carItem("Porsche", 10000, 0);
        stocks[2] = new carItem("BMW", 25000, 0);
        stocks[3] = new techItem("Apple", 45000, 0);
        stocks[4] = new techItem("Google", 40000, 0);
        stocks[5] = new techItem("Netflix", 3500, 0);
        stocks[6] = new techItem("Amazon", 40000, 0);
        stocks[7] = new cryptoItem("Bitcoin", 30000, 0);
        stocks[8] = new cryptoItem("Ethereum", 6000, 0);
        stocks[9] = new cryptoItem("DogeCoin", 1000, 0);
        
        //determine each stocks volatility
        for(Item stock: stocks){
            stock.setVolatilityByCategory();
        }

        //introduction
        System.out.println("Welcome to the stock game! \nYou start with $1,000,000 \nRules\n  1. You get to buy or sell 1 stock per day\n  2. Each stock changes price based on its volatility everday\n  3. A stocks volatility is based on its category \n     Car brands are the least volatile (7 - 9%)\n     Tech companies are somewhat volatile (18 - 25%)\n     Crypto is the most volatile (32 - 55%)");

        //main game loop

        while(keepPlaying){

            for (Item stock: stocks) { //print out all stocks
                

                if(!day1){ //if its not day 1 print out the stock price change1
                
                    System.out.println(stock.name + " - $" + stock.price + " [" + stock.priceChange + "]");
                } else{
                    System.out.println(stock.name + " - $" + stock.price);
                }
            }

            System.out.println("Would you like to buy or sell your stock? \nPress [1] to buy [2] to sell");

            int buyOrSell = Store.buyOrSell(sc.nextLine(), userItems); //returns 0 if wrong input, 1 if user buys, 2 if user sells  

            if(buyOrSell == 0){
                System.out.println("You did not type [1] or [2] Try Again");
                continue;

            } else if(buyOrSell == 1){ //if the user wants to buy 
                userBalance -= Store.buyStock(stocks, userBalance, userItems);
                     
            } else if(buyOrSell == 2 && !day1){ //if user wants to sell 
                userBalance += Store.sellStock(stocks, userBalance, userItems);

            } else{ //this will only occur when day1 is true
                System.out.println("You cannot sell any stocks! You haven't bought any stock yet!");
                continue;
            }

            for (Item stock : stocks){ //change the prices of all the stocks
                stock.changePrice();
            }
            day1 = false;
            keepPlaying = Store.keepPlaying(userBalance);
        }
    }
}
