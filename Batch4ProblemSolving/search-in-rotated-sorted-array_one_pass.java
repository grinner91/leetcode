//https://leetcode.com/problems/search-in-rotated-sorted-array
//Approach 2: One-pass Binary Search: Time - O(log n), Space - O(1)

class Solution {
    public int search(int[] nums, int target) {
        //setp: handle edge cases 
        if(nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        //step: binary search 
        //-- check conditions for rotation 
        
        int left = 0;
        int right = nums.length - 1; 
        int mid;
        
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[left] <= nums[mid]) {          
                if(target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(target > nums[mid]  && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } 
        }
        
        return -1;
    }
}
