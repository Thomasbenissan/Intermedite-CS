public class cryptoItem extends Item {
    cryptoItem(String name, int price, int amountOwned) {
        super(name, price, "Crypto", amountOwned);
    } 

    @Override
    public void setVolatilityByCategory(){
        volatility = 0.35 + (0.55 - 0.35) * rand.nextDouble();
    }
}