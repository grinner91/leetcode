//https://leetcode.com/problems/spiral-matrix-ii
//ref: inspired by leetcode solutions

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] moves = {{0, 1}, {1, 0}, {0,-1}, {-1, 0}};
        int row = 0, col = 0;
        int val = 1;
        int dir = 0;
        
        while(val <= n* n) {
            matrix[row][col] = val++;
            
            int newr = Math.floorMod(row + moves[dir][0], n);
            int newc = Math.floorMod(col + moves[dir][1], n);
            
            //change direction if next cell is non-zero 
            if(matrix[newr][newc] != 0) {
                dir = (dir + 1) % 4;
            }
            
            row += moves[dir][0];
            col += moves[dir][1];
        }
        
        return matrix;
    }
}
