public class City extends Location{
    private int population;
    public City(String name,  double coordinatesX, double coordinatesY, int population) {
        super(name, coordinatesX, coordinatesY);
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
