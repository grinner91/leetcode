class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = Int.MIN_VALUE
        var current = 0
        
        for(i in nums.indices) {
           current = maxOf(nums[i], current + nums[i])
           maxSum = maxOf(maxSum, current) 
        }
        
        return maxSum
    }
}
