public class Highway extends Road{

    int numberOflanesPerdirection;

    public Highway(String name, int lenght, int speedLimit, int numberOflanesPerdirection, double startPointx, double startPointy, double endPointx, double endPointy) {
        super(name, lenght, speedLimit, startPointx, startPointy, endPointx, endPointy);
        this.numberOflanesPerdirection = numberOflanesPerdirection;
    }


    public int getNumberOflanesPerdirection() {
        return numberOflanesPerdirection;
    }

    public void setNumberOflanesPerdirection(int numberOflanesPerdirection) {
        this.numberOflanesPerdirection = numberOflanesPerdirection;
    }
}
