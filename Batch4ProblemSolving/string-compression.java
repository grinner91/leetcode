//https://leetcode.com/problems/string-compression
class Solution {
    public int compress(char[] chars) {
        //edge cases
        if(chars.length == 1) {
            return 1;
        }
        
        int index = 0;
        int j = 0;
        while(j < chars.length) {
            char lastChar = chars[j];
            int count = 0;
            while(j < chars.length && chars[j] == lastChar) {
                j++; count++;
            }
            chars[index++] = lastChar;
        
            if(count > 1) {
                for(char ch: String.valueOf(count).toCharArray()) {
                    chars[index++] = ch;
                }
            }
        }
        
        return index;
    }
}
