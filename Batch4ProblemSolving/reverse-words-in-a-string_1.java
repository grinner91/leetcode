//151. Reverse Words in a String
//https://leetcode.com/problems/reverse-words-in-a-string/
class Solution {
    public String reverseWords(String s) {
        
        if(s.length() == 1) {
            return s.trim();
        }
        
        String str = s.trim();
        int n = str.length();
        
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if(Character.isWhitespace(ch) && sb.length() > 0) {
                result.add(0, sb.toString());
                sb.setLength(0);
            } else if(!Character.isWhitespace(ch)) { //skip whitespaces 
                sb.append(ch);
            }
        }
        //for last word
         if(sb.length() > 0) {
                result.add(0, sb.toString());
         }
        
        return String.join(" ", result);
    }
}
