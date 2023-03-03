public class Location {
    private String name;
    private LocationType type;
    private double coordinatesX;
    private double coordinatesY;

    //public Location(){}

    public Location(String name, LocationType type, double coordinatesX, double coordinatesY) {
        this.name = name;
        this.type = type;
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(LocationType type) {
        this.type = type;
    }


    public String getName() {
        return this.name;
    }

    public LocationType getType() {
        return this.type;
    }


    @Override
    public String toString() {
        return "Location:" +  " Nume: " + this.name + ", Type: " + this.type +
                ", CoordinatesX: " + this.coordinatesX + ", CoordinatesY: " + this.coordinatesY;
    }

    public void setCoordinatesX(double coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public void setCoordinatesY(double coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public double getCoordinatesX() {
        return coordinatesX;
    }

    public double getCoordinatesY() {
        return coordinatesY;
    }

    public enum LocationType {CITY, AIRPORT, GAS_STATION}


}
