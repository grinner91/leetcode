//https://leetcode.com/problems/search-in-rotated-sorted-array
class Solution {
    public int search(int[] nums, int target) {
        //edge cases 
        if(nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        //step: find the rotation index 
        int rotationIndex = findRotateIndex(nums);
        //System.out.println("rotationIndex: " + rotationIndex);
        //step: left side binary search before rotation index
        int index = findTargetBinarySearch(nums, target, 0, rotationIndex - 1);
        //step: if not found, right side binary search after rotation index 
        if(index < 0) {
           index = findTargetBinarySearch(nums, target, rotationIndex, nums.length - 1);
        }
        return index;
    }
    
    private int findTargetBinarySearch(int[] nums, int target, int left, int right) {
        int mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if( nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    /*
    nums = [7, 0, 1, 2], target = 0
            0  1  2  3  4  5  6
            
   it1: l = 0, r = 3, m = 2
        l = 0, r = 1, m = 1
    
    */
    private int findRotateIndex(int[] nums) {
       
        int left = 0; 
        int right = nums.length - 1;
    
        if(nums[left] < nums[right]) {
            return nums.length;
        }
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else {
                if(nums[mid] < nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        
        return nums.length;
    }
}
