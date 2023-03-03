public class Road {

    private String name;
    private int lenght;
    private RoadType type;
    private int speedLimit;

    //public Road(){}
    public Road(String name, int lenght, RoadType type, int speedLimit){
        this.name = name;
        this.speedLimit = speedLimit;
        this.type = type;
        this.lenght = lenght;
    }

    public int getLenght() {
        return lenght;
    }

    public RoadType getType() {
        return type;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Road " +
                "name=" + name +
                ", lenght=" + lenght +
                ", type=" + type +
                ", speedLimit=" + speedLimit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public enum RoadType{HIGHWAYS, EXPRESS}


}
