class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        var sum = 0
        for(i in nums.indices) {
            sum = sum + nums[i]
        
            if(sum > max) {
                max = sum
            }
    
            if(sum < 0) { 
                sum = 0
            }
        }
        return max
    }
}