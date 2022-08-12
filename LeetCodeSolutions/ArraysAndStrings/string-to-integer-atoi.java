//https://leetcode.com/problems/string-to-integer-atoi
class Solution {
    public int myAtoi(String s) {
        //handle edge cases 
        if(s.length() == 0) {
            return 0;
        }
    
        char[] chars = s.toCharArray();
        int len = chars.length;
        
        //skip all whitespace 
        int index = 0;
        while(index < len) {
            if(Character.isWhitespace(chars[index])) {
                index++;
            } else {
                break;
            }
        }
        
        //check if -, + sign 
        int sign = 1;
        if(index < len && chars[index] == '-') {
            sign = -1;
            index++;
        } else if(index < len && chars[index] == '+') {
            index++;
        }
        
         //System.out.println(Integer.MIN_VALUE + ", " + Integer.MAX_VALUE);
        //-2147483648, 2147483647
        //caculate number 
        int ans = 0;
        while(index < len && Character.isDigit(chars[index])) {
            int digit = chars[index] - '0';
            //checking if overflow or underflow  
            if((ans > Integer.MAX_VALUE / 10)  
               || (ans == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ?  Integer.MAX_VALUE : Integer.MIN_VALUE;
            } 
            ans = ans * 10 + digit;
            index++;
        }
        
        return sign * ans;
    }
}

/*
time(n) - O(n)
space(n) - O(1)
*/
