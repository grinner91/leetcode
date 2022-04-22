//13. Roman to Integer
//https://leetcode.com/problems/roman-to-integer/

class Solution {
    fun romanToInt(s: String): Int {
        
        var sum = getRomanToNum(s[s.lastIndex])
     
        for(i in (s.length - 2) downTo 0 step 1) {
            val current = getRomanToNum(s[i])
            val next = getRomanToNum(s[i+1])
            if(current < next) 
                sum -= current
            else 
                sum += current
        }
        return sum
    }
    
    fun getRomanToNum(roman: Char) = when(roman) {
        'I' ->  1
        'V' ->  5
        'X' ->  10
        'L' ->  50
        'C' ->  100
        'D' ->  500
        'M' -> 1000
        else -> 0
    }
    
}
