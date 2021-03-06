//https://leetcode.com/problems/sqrtx
class Solution {
    public int mySqrt(int x) {
        if(x <= 1) {
            return x;
        }
        
        int left = 1;
        int right = x;
        int mid;
        
        while(left <= right) {
            mid = left + (right - left) / 2;
            if((long) mid * mid == x) {
                return mid;
            } else if((long) mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }
}
