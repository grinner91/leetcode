//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var left = findLeftPositionBinarySearch(nums, target)
        var right = findRightPositionBinarySearch(nums, target)
        return intArrayOf(left, right)
    }
    
    fun findLeftPositionBinarySearch(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        
        while(left <= right) {
            var mid = ( left + right ) / 2
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid - 1] != target){
                    return mid
                }
                right = mid - 1
            } else if(nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        return -1
    }
    
    fun findRightPositionBinarySearch(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while(left <= right) {
            var mid = ( left + right ) / 2
            if(nums[mid] == target) {
                if(mid == nums.size - 1 || nums[mid + 1] != target) {
                    return mid
                }
                left = mid + 1
            } else if(nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        return -1
    }
}
