import java.util.Arrays;
import java.util.Objects;


public class Problem {
    private Location[] locations = new Location[5];
    private Road[] roads = new Road[5];
    private Location[] connectedLocations = new Location[5];
    private int[][] matrixGraph = new int[5][5];
    int counterLoc = 0;
    int counterRoad = 0;

    public Problem() {
    }

    /**
     * Generating an array of all Location
     * This will help us to not repeat the same location.
     * @param o
     * @return
     */
    public boolean addLocation(Object o) {
        if (counterLoc == 0) {
            locations[counterLoc] = (Location) o;
            counterLoc++;
            return true;
        } else {
            for (int i = 0; i < counterLoc; i++) {
                if (this.locations[i].equals(o)) {
                    System.out.println("Acest " + ((Location) o).getName() + " a mai fost introdus odata");
                    return false;
                } else {
                    locations[counterLoc] = (Location) o;
                }
            }
            counterLoc++;
        }
        return true;
    }

    /**
     * Generating an array of all Roads
     * This will help us to not repeat the same location.
     * @param o
     * @return
     */
    public boolean addRoad(Object o) {
        if (counterRoad == 0) {
            roads[counterRoad] = (Road) o;
            counterRoad++;
            return true;
        } else {
            for (int i = 0; i < counterRoad; i++) {
                if (this.roads[i].equals(o)) {
                    System.out.println("Acest " + ((Road) o).getName() + " a mai fost introdus odata");
                    return false;
                } else {
                    roads[counterRoad] = (Road) o;
                }
            }
            counterRoad++;
        }
        return true;
    }

    /**
     * This function create an incidence matrix
     *             Road 1    Road 2    Road 3     |
     * Location 1    0         1         1        |   exemple of an incidence matrix
     * Location 2    1         1         0        |   it say us which locations meet which roads
     * Location 3    1         0         1        |
     */
    public void createGrafmatrix() {
        for (int i = 0; i < counterLoc; i++) {
            for (int j = 0; j < counterRoad; j++) {
                if (((locations[i].getCoordinatesY() == roads[j].getEndPointY()) || (locations[i].getCoordinatesY() == roads[j].getStartPointY())) && ((locations[i].getCoordinatesX() == roads[j].getEndPointX()) || (locations[i].getCoordinatesX() == roads[j].getStartPointX()))) {
                    matrixGraph[i][j] = 1;
                } else {
                    matrixGraph[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrixGraph));
    }

    /**
     * speaking about a valid problem, the problem, as it is described, consist in determining the "best" route from one location to another
     * In my opinion a problem is not valid when a location has no roads
     * In this direction this function search if a location has any roads.
     * @param l1
     * @return
     */
    public boolean valid(Location l1) { // a problem is valid if the location is not isolated.
        int count1 = 0;

        for (int i = 0; i < counterLoc; i++) {
            if (Objects.equals(locations[i].getName(), l1.getName())) {
                count1 = i;
            }
        }
        for (int j = 0; j < counterRoad; j++) {
            if (matrixGraph[count1][j] == 1) {
                System.out.println("Localitatea " + l1.getName() + " nu este izolata, deci problema este valida.");
                return true;
            }
        }
        System.out.println("Localitatea " + l1.getName() + " este izolata, deci problema nu este valida.");
        return false;
    }

    /**
     * This function should provide an answer regarding the question "There is any road between Location x and Location y?"
     * unfortunately it don t works correctly, it is only returning an answer yes or not only if there is a direct read to any 2 location.
     * @param l1
     * @param l2
     * @return
     */
    public boolean connected( Location l1, Location l2) {
        int temp = 0;
        for (int i = 0; i < counterLoc - 1; i++) {
            for (int j = 0; j < counterRoad; j++) {
                if ((matrixGraph[i][j] == 1) && (matrixGraph[i + 1][j] == 1)) {
                    connectedLocations[i] = locations[i];
                }
            }
        }
        for(int i = 0; i < connectedLocations.length; i++){
            if (l1.equals(connectedLocations[i])){
                temp++;
            }
            if (l2.equals(connectedLocations[i])){
                temp++;
            }
        }
        if(temp == 2) {
            System.out.println("Localitatile sunt conectate.");
            return true;
        }
        System.out.println("Localitatile NU sunt conectate.");
        return false;
    }

}
