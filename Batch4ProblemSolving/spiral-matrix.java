//https://gist.github.com/grinner91/33ca30d6a3b4b919c8f5968de53ef637

//https://leetcode.com/problems/spiral-matrix
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        /*
        //handle edge cases
        //edge case: 1 row matrix 
        [[6,9,7]]
        //edge case: 1 col matrix
        [[6], [9], [7]]
        //edge case: 1 x 1 matrix
        [[3]]
        */
       
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int up = 0;
        int down = rows - 1;
        int left = 0;
        int right = cols - 1;
        
        List<Integer> result = new ArrayList<>();
        
        while(result.size() < rows * cols) {
            //add top row values left to right
            for(int c = left; c <= right; c++) {
                result.add(matrix[up][c]);
            }
            //add last column values top to bottom 
            for(int r = up + 1; r <= down; r++) {
                result.add(matrix[r][right]);
            }
            //add last row values right to left 
            for(int c = right - 1; c >= left && up != down; c--) {
                result.add(matrix[down][c]);
            }
            //add 1st col values bottom to top
            for(int r = down - 1; r > up && left != right; r--) {
                result.add(matrix[r][left]);
            }
            
            up++; down--; left++; right--;
        }
            
        return result;
    }
}
