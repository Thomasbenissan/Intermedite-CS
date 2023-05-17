package SuperStore;
public class techItem extends Item {
    techItem(String name, int price, int amountOwned) { 
        super(name, price, "Tech", amountOwned);
    }

    @Override
    public void setVolatilityByCategory () {
        volatility = 0.20 + (0.35 - 0.20) * rand.nextDouble();;
    }
}

