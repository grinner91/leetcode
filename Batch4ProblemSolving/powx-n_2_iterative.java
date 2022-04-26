//https://leetcode.com/problems/powx-n
//ref: leetcode solutions
//

class Solution {
    public double myPow(double x, int n) {
        //IntMIN: -2147483648,  IntMAX: 2147483647
        long pow = n; //long, consider overflow
        if( pow < 0) {
            x = 1/x; 
            pow = -pow; //consider -overflow 
        }
        
        //System.out.println("IntMIN: "+Integer.MIN_VALUE + ",  IntMAX: " + Integer.MAX_VALUE);
        
        // n is even, x^n = x^n/2 * x^n/2;
        // n is odd, x^n = x^n/2 * x^n/2 * x;
        
        double ans = 1.0;
        double prod = x;
        for(long i = pow; i > 0; i/=2) {
            if(i % 2 == 1) {
                ans = ans * prod;
            } 
            prod = prod * prod;
        }
        
        return ans;
    }
}
