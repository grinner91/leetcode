//186. Reverse Words in a String II
//https://leetcode.com/problems/reverse-words-in-a-string-ii
//ref: leetcode solutions 
class Solution {
    public void reverseWords(char[] s) {
        //step: reverse whol string 
        reverseString(s, 0, s.length - 1);
        
        //step: reverse each word 
        reverseEachWord(s);
    }
    
    private void reverseString(char[] str, int left, int right) {
        while(left < right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }
    
    private void reverseEachWord(char[] str) {
        int n = str.length;
        for(int start = 0, end = 0; start < n;) {
            //travese end of the earch word 
            while(end < n && str[end] != ' ') {
                end++;
            }
            //reverse current word 
            reverseString(str, start, end - 1);
            //update start until end, move to next word 
            start = end + 1;
            end++;
        }
    }
}
