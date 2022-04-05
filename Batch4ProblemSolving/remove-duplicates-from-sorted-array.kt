class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if(nums == null || nums.size == 0) 
            return 0
        
        var j: Int = 0
        for (i in 1..nums.lastIndex) {
            if(nums[j] != nums[i]) {
                j++
                nums[j] = nums[i]
            }
        } 
        
        return j + 1
    }
}