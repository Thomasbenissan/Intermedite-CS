import java.util.Random;

 
public class Item{
    //fields
    int price;
    double volatility;
    String name;
    String cat;
    int amountOwned;
    int priceChange; 

    //class vars
    Random rand = new Random();

    // constructor

    Item(String name, int price, String cat, int amountOwned){
        this.price = price;
        this.cat = cat;
        this.name = name;
        this.amountOwned = amountOwned;
    }

    //methods

    public void setVolatilityByCategory() {
        switch (cat) {
            case "Car":
                volatility = 0.8 + (0.15 - 0.8) * rand.nextDouble();
                break; 
            case "Tech":
                volatility = 0.20 + (0.35 - 0.20) * rand.nextDouble();;
                break;
            case "Crypto":
                volatility = 0.35 + (0.55 - 0.35) * rand.nextDouble();
                break;
        }
    }

    public void changePrice(){

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
