import java.util.Objects;

public abstract class Location {
    private String name;
    private double coordinatesX;
    private double coordinatesY;

    //public Location(){}

    public Location(String name, double coordinatesX, double coordinatesY) {
        this.name = name;
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.coordinatesX, coordinatesX) == 0 && Double.compare(location.coordinatesY, coordinatesY) == 0 && Objects.equals(name, location.name);
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getName() {
        return this.name;
    }



    @Override
    public String toString() {
        return "Location:" +  " Nume: " + this.name +
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



}
