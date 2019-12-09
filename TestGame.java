package edu.neu.coe.info6205.GA;

public class TestGame {

    private final int[][] dir = {{1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1}};
//应该是检查有多少neighbor
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int live = 0;
                for(int[] d : dir) {
                    if(d[0] + i < 0 || d[0] + i > board.length - 1
                            || d[1] + j < 0 || d[1] + j > board[0].length - 1) {
                        continue;
                    }
                    if(board[i + d[0]][j + d[1]] == 1 || board[i + d[0]][j + d[1]] == 2) {
                        live++;
                    }
                }
                if(board[i][j] == 0 && live == 3) {
                    board[i][j] = 3;
                }
                if(board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                }
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                } else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
