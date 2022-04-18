//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //step: handle edge cases 
        if(nums == null || nums.length == 0) {
            return new int[] { -1, -1};
        }
        //step: find target by binary search and check fist position in left-subarray 
        int first = findFirstPositionByBinarySearch(nums, target);
        //step: find traget by binary search and check last position in right sub-array 
        
        int last = findLastPositionByBinarySearch(nums, target);
        
        return new int[] {first, last};
    }
    
    
    int findFirstPositionByBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                if(mid == left || nums[mid] != nums[mid - 1]) {
                    return mid;
                }
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    int findLastPositionByBinarySearch(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1; 
        int mid;
        
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                if(mid == right || nums[mid] != nums[mid + 1]) {
                    return mid;
                }
                left = mid + 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
}
