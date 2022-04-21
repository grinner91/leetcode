//https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
class Solution {
   
    
    public int lengthOfLongestSubstring(String s) {
        //handle edge cases 
        if(s.length() == 0) {
            return 0;
        }
        //step: start index of substring/window, start 
        //step: end index of substring/window with character without repeat
        //step: keep updating start and end, and keep maxLen of substring without repeat 
        int len = s.length();
        int start = 0; 
        int end = 1; 
        int maxLen = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(start), 0);
        
        for(;start < len && end < len; end++) {
            char ch = s.charAt(end);
            //check if there is repeating chars 
             //if repeat then update start until this repeating char
            if(map.containsKey(ch)) {
              if( map.get(ch) >= start) {
                    start = map.get(ch)+1;
              }
            } 
            map.put(ch, end);
            
            maxLen = Math.max(maxLen, end - start + 1);
            //if not repeat then increment end 
            
        }
        
        return maxLen;
    }
    
}
