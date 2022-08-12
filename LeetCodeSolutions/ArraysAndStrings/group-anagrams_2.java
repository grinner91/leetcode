//49. Group Anagrams
//https://leetcode.com/problems/group-anagrams/
/*
        solution1: if use sorted word  time compelexity: O(n * klogk)
        solution2: if use counts letters, time complexity: O(n * k)
        
        step: sort each word  //O(klogk) k is the length of each word
        //step: keep map and use as key - sorted word //O(n)
        //step: update map with words with same/anagrams 
        //total: time - O(n * klogk)
    
    */

class Solution {
   
    public List<List<String>> groupAnagrams(String[] strs) {
        //solution 2
        Map<String, List<String>> groupsMap = new HashMap<>();
        for(String str: strs) { //O(n), n is the lenght of strs 
    
            String key = generateKey(str);
            
            if(!groupsMap.containsKey(key)) {
                groupsMap.put(key, new ArrayList<String>());
            }
             groupsMap.get(key).add(str);
        }
        
        return new ArrayList(groupsMap.values());
    }
    
    private String generateKey(String str) {
        //time complexity: O(k), k is the length of max string
        int[] count = new int[26];
        for(char ch: str.toCharArray()) {
            count[ch - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            sb.append("#");
            sb.append(count[i]);
        }
        
        return sb.toString();
    }
}
