//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int start = findPositionByBinarySearch(nums, target, true);
        int end = findPositionByBinarySearch(nums, target,  false);
        
        return new int[] {start, end};
    }
    
    private int findPositionByBinarySearch(int[] nums, int target,  boolean isStart) {
        int left = 0; 
        int right = nums.length - 1;
        int mid;
        
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                if(isStart == true) { //starting position
                    if(mid == left || nums[mid - 1] != target) 
                        return mid;
                     else 
                         right = mid - 1;
                } else { //for ending position 
                    if(mid == right || nums[mid+1] != target)
                        return mid;
                    else 
                         left = mid + 1;
                
                    }
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
}
