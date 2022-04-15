//https://leetcode.com/problems/spiral-matrix-ii
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1;
        int val = 1;
        
        while(val <= n * n) {
            
            //traverse up row until last column
            for(int c = left; c <= right; c++) {
                matrix[up][c] = val++;
            }
            
            //traverse up to down along last column 
            for(int r = up + 1; r <= down; r++) {
                matrix[r][right] = val++;
            }
            
            //traverse down row from right to left 
            for(int c = right - 1; c >= left && up != down; c--) {
                matrix[down][c] = val++;
            }
            
            //traverse down to up along with 1st column 
            for(int r = down - 1; r > up && left != right; r--) {
                matrix[r][left] = val++;
            }
            
            //update matrix boundaries 
            up++; down--; left++; right--;
        }
        
        return matrix;
    }
}
