package edu.neu.coe.info6205.GA;

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        TestGame testGame = new TestGame();
        Test.Pack pattern = test.findPattern();
        // notice!!
        int[][] board = test.transform(pattern);
        //
        for(int k = 0; k < 1000; k++) {
            for(int i = 0; i < 48; i++) {
                for(int j = 0; j < 48; j++) {
                    if(board[i][j] == 1) {
                        System.out.print("o ");
                    } else {
                        System.out.print(". ");
                    }
                }
                System.out.println();
            }
            testGame.gameOfLife(board);
            Thread.sleep(500);
        }

    }
}
