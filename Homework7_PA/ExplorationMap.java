package org.example;

/**
 * Class ExplorationMap represents the map
 * It contains a matrix of cells representing the map
 */
public class ExplorationMap {
    private final Cell[][] matrix;
    public ExplorationMap() {
        matrix = new Cell[5][5];
          for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                matrix[i][j] = new Cell();
            }
    }
    }

    /**
     * Method "visit" checks if the cell is visited
     * @param row
     * @param col
     * @param robot
     * @return true if the cell is not visited, false otherwise
     */
    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (matrix[row][col].getList().get(0).getNumber() == -1) {
                matrix[row][col].setList(robot.extractTokens());
                return true;
            }
            }

     return false;
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

}
