public class Airport extends Location{

    private int personal;
    public Airport(String name, double coordinatesX, double coordinatesY, int personal) {
        super(name, coordinatesX, coordinatesY);
        this.personal = personal;
    }

    public int getPersonal() {
        return personal;
    }

    public void setPersonal(int personal) {
        this.personal = personal;
    }
}
