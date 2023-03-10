public abstract class Road {

    private String name;
    private int lenght;
    private int speedLimit;
    private double startPointx;
    private double startPointy;
    private double endPointx;
    private double endPointy;

    //public Road(){}
    public Road(String name, int lenght, int speedLimit, double startPointx, double startPointy, double endPointx, double endPointy) {
        this.name = name;
        this.speedLimit = speedLimit;
        this.lenght = lenght;
        this.startPointx = startPointx;
        this.startPointy = startPointy;
        this.endPointx = endPointx;
        this.endPointy = endPointy;
    }

    public int getLenght() {
        return lenght;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public String getName() {
        return name;
    }

    public double getStartPointX() {
        return startPointx;
    }

    public double getStartPointY() {
        return startPointy;
    }

    public double getEndPointX() {
        return endPointx;
    }

    public double getEndPointY() {
        return endPointy;
    }

    @Override
    public String toString() {
        return "Road " +
                "name=" + name +
                ", lenght=" + lenght +
                ", speedLimit=" + speedLimit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public void setStartPointX(double startPointx) {
        this.startPointx = startPointx;
    }

    public void setStartPointY(double startPointy) {
        this.startPointy = startPointy;
    }

    public void setEndPointX(double endPointx) {
        this.endPointx = endPointx;
    }

    public void setEndPointY(double endPointy) {
        this.endPointy = endPointy;
    }
}
