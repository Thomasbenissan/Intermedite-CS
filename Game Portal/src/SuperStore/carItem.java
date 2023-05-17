package SuperStore;
public class carItem extends Item {
    carItem(String name, int price, int amountOwned) {
        super(name, price, "Car", amountOwned); 
    }

    @Override
    public void setVolatilityByCategory() {
        volatility = 0.8 + (0.15 - 0.8) * rand.nextDouble();
    }
}