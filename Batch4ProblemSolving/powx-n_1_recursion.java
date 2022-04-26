//50. Pow(x, n)
//https://leetcode.com/problems/powx-n
//ref: inspired by leetcode solutions

class Solution {
    public double myPow(double x, int n) {
        if(n < 0) {
            x = 1/x;
            n = -n;
        }
        
        return fastPower(x, n);
    }
    
    private double fastPower(double x, int n) {
        if(n == 0)  {
            return 1.0;
        }
        if(n == 1) {
            return x;
        }
        
        double halfPow = fastPower(x, n/2);
        //if n is even, then x^n = x^n/2 * x^n/2 
        if(n % 2 == 0) {
            return halfPow * halfPow;
        } else {
            //if n is odd, then  x^n = x^n/2 * x^n/2 * x
            return halfPow * halfPow * x;
        }
    }
}
