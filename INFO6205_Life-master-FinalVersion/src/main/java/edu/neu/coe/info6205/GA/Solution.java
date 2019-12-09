package edu.neu.coe.info6205.GA;

public class Solution {
    private int m;
    private int n;
    private int[][] matrix;
    private int[][] cache;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        if(m == 0) {
            return 0;
        }
        n = matrix[0].length;
        this.matrix = matrix;
        cache = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }
        return max;
    }

    private int dfs(int i, int j) {
        if(cache[i][j] != 0) {
            return cache[i][j];
        }
        int max = 1;
        if(i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            max = Math.max(max, 1 + dfs(i - 1, j));
        }
        if(j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            max = Math.max(max, 1 + dfs(i, j - 1));
        }
        if(i < m - 1 && matrix[i + 1][j] > matrix[i][j]) {
            max = Math.max(max, 1 + dfs(i + 1, j));
        }
        if(j < n - 1 && matrix[i][j + 1] > matrix[i][j]) {
            max = Math.max(max, 1 + dfs(i, j + 1));
        }
        cache[i][j] = max;
        return max;
    }
}
