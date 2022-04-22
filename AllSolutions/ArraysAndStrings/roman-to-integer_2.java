//13. Roman to Integer
//https://leetcode.com/problems/roman-to-integer/solution/
class Solution {
    public int romanToInt(String s) {
        //step: iterate from rigth to left 
        //step: sum up , roman to value 
        //      if left element is less then right element, then subtract 
        //     otherwise, sum up 
        
        //Time(n) : O(n) -> O(1) since, roman numbers are finite 
        // space(n) : O(1) 
        
        //constraints: 1 <= s.len <= 15
        //add last digit 
        int sum = getRomanToNum(s.charAt(s.length() - 1));
        //iterate from 2nd digit if any
        for(int i = s.length() - 2; i >= 0; i--) {
            int next = getRomanToNum(s.charAt(i + 1));
            int current =  getRomanToNum(s.charAt(i));
            if(current < next) {
                sum -= current;
            } else {
                sum += current;
            }
        }
        
        return sum;
    }
       
    private int getRomanToNum(char roman) {
        switch(roman) {
            case 'I': return 1;
            case 'V': return 5; 
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
