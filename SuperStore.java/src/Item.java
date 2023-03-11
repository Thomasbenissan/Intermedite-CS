import java.util.Random;

public class Item{
    //fields
    int price;
    double volatility;
    String name;
    int amountOwned;
    int priceChange;


    // constructor

    Item(String name, int price, double volatility, int amountOwned){
        this.price = price;
        this.volatility = volatility;
        this.name = name;
        this.amountOwned = amountOwned;
    }

    //methods

    public void changePrice(){
        Random rand = new Random();
        int random = rand.nextInt(2);

        if(random == 0){ //stock increases price

            priceChange = (int) (price*(1 + volatility) - price ); //final price minus start price   
            price *= (1 + volatility);

            
        }else{ //stock decreases price

            priceChange = (int) (price*( 1 - volatility) - price ); 
            price *= (1 - volatility);
        }

    }

}
