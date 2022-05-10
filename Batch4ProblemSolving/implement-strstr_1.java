//28. Implement strStr()
//https://leetcode.com/problems/implement-strstr/

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.isEmpty()) {
            return 0;
        }
        
        int n1 = haystack.length();
        int n2 = needle.length();
        boolean mismatch;
        
        for(int i = 0; i < n1 - n2 + 1; i++) {
            mismatch = false;
            for(int j = 0; j < n2; j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    mismatch = true;
                    break;
                }
            }
            if(!mismatch) {
                return i;
            }
        }
        
        return -1;
    }
}
