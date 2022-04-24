//557. Reverse Words in a String III
//https://leetcode.com/problems/reverse-words-in-a-string-iii/solution/
class Solution {
    public String reverseWords(String s) {
        //step: iterate over string and reverse each word 
        int n = s.length();
        char[] arr = s.toCharArray();
        int start = 0;
        int end = 0;
        
        while(start < n) {
            //move to end of the current word
            while(end < n && arr[end] != ' ') {
                end++;
            }
            //reverse current word in-place
            reverseString(arr, start, end - 1);
           
            //start from next word 
            start = end + 1;
            //
            end++;
        }
        
        return String.valueOf(arr);
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
}
