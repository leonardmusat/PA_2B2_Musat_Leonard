public class GasStation extends Location{
    private double gasPrice;

    public GasStation(String name, double coordinatesX, double coordinatesY, double gasPrice) {
        super(name, coordinatesX, coordinatesY);
        this.gasPrice = gasPrice;
    }

    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }

    public double getGasPrice() {
        return gasPrice;
    }
}
