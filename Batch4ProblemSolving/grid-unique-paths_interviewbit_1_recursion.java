//https://www.interviewbit.com/problems/grid-unique-paths/
public class Solution {
    public int uniquePaths(int A, int B) {
        return uniquePathsRecursion(0, 0, A, B);
    }

    int uniquePathsRecursion(int r, int c, int A, int B) {
        //base conditions 
        //reached to target cell of the grid, so path count is 1 
        if(r == A - 1 && c == B - 1) {
            return 1;
        } 
        //exits boundaries, not consider 
        if(r >= A || c >= B) {
            return 0;
        }

        //count paths from current node (r,c), if moving down, row + 1 
        int downCount = uniquePathsRecursion(r + 1, c, A, B);
        //count paths from current node (r, c), if moving right, col + 1
        int rightCount = uniquePathsRecursion(r, c + 1, A, B);

        //total paths from current node (r, c), two branchs (down, right)
        return downCount + rightCount;
    }
}
