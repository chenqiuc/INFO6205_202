package edu.neu.coe.info6205.GA;

/**
 * GAUtil.java implement a function named transform.
 * It is aimed to transform pattern(String) which genotype to a two-dimensional array.
 * We will use the two-dimensional array in UI
 */
public class GAUtil {

    /**
     * Find two-dimensional array from starting pattern as the starting array of the game of life.
     * Array is used by UI.
     * @param pattern
     */
    public int[][] transform(String pattern) {
        int[][] board = new int[32][32];
        String[] split = pattern.split(", ");
        for(String str : split) {
            String[] s = str.split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            board[x + 8][y + 8] = 1;
        }
        return board;
    }

}
