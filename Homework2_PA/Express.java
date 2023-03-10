public class Express extends Road{

    int intersections;

    public Express(String name, int lenght, int speedLimit, int intersections, double startPointx, double startPointy, double endPointx, double endPointy) {
        super(name, lenght, speedLimit, startPointx, startPointy, endPointx, endPointy);
        this.intersections = intersections;
    }


    public int getIntersections() {
        return intersections;
    }

    public void setIntersections(int intersections) {
        this.intersections = intersections;
    }
}
