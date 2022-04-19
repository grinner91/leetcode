//https://leetcode.com/problems/reverse-string
class Solution {
    public void reverseString(char[] s) {
        /*
        ["h","e","l","l","o"] 
        n = 5 = 5 / 2 = 2 
        if len odd , then i < n / 2;
        
        if n even, 
        n = 2, i < n / 2 = 1
        n = 4, i < n / 2 = 2
        */
        
        if(s.length == 1) {
            return;
        }
        int n = s.length ;
        for(int i = 0; i < n / 2; i++) {
            char ch = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = ch;
        }
        
    }
}
