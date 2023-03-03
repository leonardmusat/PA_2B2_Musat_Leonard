public class Main {
    public static void main(String[] args) {
        Location iasi = new Location("Iasi", Location.LocationType.CITY, 0.0, 0.0);
        Location galati = new Location("Galati", Location.LocationType.CITY, 10.10, 10.10);
        Road dn1 = new Road("DN1", 200, Road.RoadType.EXPRESS, 90);
        Road modovianHighway = new Road("Moldovian Highway", 400, Road.RoadType.HIGHWAYS, 140);
        System.out.println(iasi);
        System.out.println(galati);
        System.out.println(dn1);
        System.out.println(modovianHighway);
    }

}