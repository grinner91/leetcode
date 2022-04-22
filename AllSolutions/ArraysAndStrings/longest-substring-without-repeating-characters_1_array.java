//https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
class Solution {
    //Time : O(n), n is lenth of string, iterate n times 
    //spece: O(m), m is the size of charset
    public int lengthOfLongestSubstring(String s) {
        //handle edge cases: 
        if(s.length() <= 1) {
            return s.length();
        }
        //iterate over chars and check if char repeat in start to end or not
        //if repeat update sliding window with start-end 
        //otherwise, extend range 
        //update maxLen until end char 
        //ASCII - chars 128, Extended ASCII - 256
        Integer[] indices = new Integer[128];
        
        int len = s.length();
        int maxLen = 1;
        
        for(int start = 0, end = 0; end < len; end++) {
            char ch = s.charAt(end);
            
            Integer chIndex = indices[ch];
            if(chIndex != null && chIndex >= start && chIndex < end) {
                start = chIndex + 1;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            indices[ch] = end;
        }
        
        return maxLen;
    }
}
