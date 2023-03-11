public class Main {
    public static void main(String[] args) {
        Location iasi = new City("Iasi", 10.0, 0.0, 300000);
        Location galati = new City("Galati", 0.0, 0.0, 250000);
        Location airport = new Airport("Iasi's airport", 7.0, 5.0, 100);
        Location petrom = new GasStation("Petrom", 9.0, 4.0, 4.69);
        Location braila = new City("Braila", 0.0, -7.0, 200000);

        Road dj1 = new Express("DJ1", 200, 90, 3, 10.0, 0.0, 9.0, 4.0);
        Road dj2 = new Express("DJ2", 200, 90, 4, 9.0, 4.0, 7.0, 5.0);
        Road moldovianHighway = new Highway("Moldovian Highway", 400, 140, 4, 0.0, 0.0, 10.0, 0.0);
        Road dn1 = new Express("DN1", 350, 100, 2, 0.0, 0.0, 7.0, 5.0);

        Problem prob = new Problem();
        prob.addRoad(dj1);
        prob.addRoad(moldovianHighway);
        prob.addRoad(dj1);
        prob.addRoad(dn1);
        prob.addRoad(dj2);
        prob.addLocation(iasi);
        prob.addLocation(galati);
        prob.addLocation(iasi);
        prob.addLocation(airport);
        prob.addLocation(petrom);
        prob.addLocation(braila);
        prob.createGrafmatrix();
        prob.valid(galati);
        prob.connected(galati, braila);
        prob.connected(galati, iasi);
        //prob.connected(petrom, airport);
        prob.valid(braila);

    }

}