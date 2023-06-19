//https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
//1768. Merge Strings Alternately

class Solution {
    func mergeAlternately(_ word1: String, _ word2: String) -> String {
        var result = ""
        for (c1, c2) in zip(word1, word2) {
            result += [c1, c2]
        }
       
        if word1.count > word2.count {
            result += word1[word2.endIndex...]
        } else if word2.count > word1.count {
            result += word2[word1.endIndex...]
        }
       
        return result
    }
}
