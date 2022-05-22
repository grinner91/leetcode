//438. Find All Anagrams in a String
//https://leetcode.com/problems/find-all-anagrams-in-a-string/

class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        
        //step: count frequency of anagram pattern chars 
        Map<Character, Integer> pCounts = new HashMap<>();
        for(int i = 0; i < plen; i++) {
            char key = p.charAt(i);
            pCounts.put(key, pCounts.getOrDefault(key, 0) + 1);
        }
        
        Map<Character, Integer> subsCounts = new HashMap<>();
        List<Integer> indices = new ArrayList<>();
        
        //step: iterate over string
        //slides window left to right with pattern plen
        for(int i = 0; i < slen ; i++) {
            char key = s.charAt(i);
            //step: count letters in subs with i-th index, in current window
            subsCounts.put(key, subsCounts.getOrDefault(key, 0) + 1);

            //step: remove left letter in current window
            //if i >= pattern len, then slide window left to right 
            if(i >= plen) {
                char left = s.charAt(i - plen);
                subsCounts.put(left, subsCounts.get(left) - 1);
                if(subsCounts.get(left) == 0) {
                    subsCounts.remove(left);
                }
            }
            
            //step: compare hashmap-counts-p == hashmap-counts-subs then anagram             
            //compare hashmap all key-value are same  
            if(pCounts.equals(subsCounts)) {
                indices.add(i - plen + 1);
            }
        }
        
        return indices;
    }
    
    
}
