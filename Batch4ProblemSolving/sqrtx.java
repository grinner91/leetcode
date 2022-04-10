//https://leetcode.com/problems/sqrtx/solution/
//using Binary Search 
class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;

        long left = 2;
        long right = x / 2 + 1;
        long mid;
        
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(mid * mid == x) {
                return (int) mid;
            } else if(mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return (int) right;
    }
}
