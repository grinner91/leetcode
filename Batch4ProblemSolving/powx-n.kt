//https://leetcode.com/problems/powx-n/solution/
class Solution {
    fun myPow(x: Double, n: Int): Double {
        var a: Double = x
        var y: Long = n.toLong()
        
        if(y < 0){
            a = 1 / a
            y = -y
        }
        
        var ans: Double = 1.0
        var prod: Double = a
        
        while(y > 0) {
            if(y % 2 == 1L) ans = ans * prod
            //println(ans)
            prod = prod * prod
            y = y / 2
        }
        
        return ans
    }
}
