//https://leetcode.com/problems/string-compression
class Solution {
    fun compress(chars: CharArray): Int {
        //step: handle edge cases 
        if(chars.size == 1) {
            return 1
        }
        
        var index = 0
        var i = 0
        while(i <= chars.lastIndex) {
            var count = 0
            var lastChar = chars[i]
            
            //iterate over until mismatch with last char 
            while(i <= chars.lastIndex && chars[i] == lastChar) {
                i++
                count++
            }
    
            chars[index++] = lastChar
            
            if(count > 1) {
                for(ch in count.toString().toCharArray()) {
                    chars[index++] = ch
                }
            }
        }
        
        return index
    }

}
