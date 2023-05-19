package Homework;

import java.util.Arrays;

public class Board {
    int[][] board = new int[15][15];

    public Board() {
        for (int[] row: board)
            Arrays.fill(row, 0);
    }

    public void set(int x, int y, int sign){
        board[x][y] = sign;
    }
}
