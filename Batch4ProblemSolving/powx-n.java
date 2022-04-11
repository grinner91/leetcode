//https://leetcode.com/problems/powx-n/solution/

class Solution {
    public double myPow(double x, int n) {
        if(n < 0) return myPow(1/x, -n);
        else if(n == 0) return 1.0;
        else if(n == 1) return x;
        else if(n % 2 == 0) return myPow(x * x, n / 2);
        else  return myPow(x * x, n / 2) * x;
    }
}
