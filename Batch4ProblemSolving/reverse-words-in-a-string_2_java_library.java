//151. Reverse Words in a String
//https://leetcode.com/problems/reverse-words-in-a-string/
class Solution {
    public String reverseWords(String s) {
        String str = s.trim();
        List<String> wordList = Arrays.asList(str.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
