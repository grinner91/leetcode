//31. Next Permutation
//https://leetcode.com/problems/next-permutation/
//ref: inspired by leetcode solutions 

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //for decreasing order, no next larger permutation, it will be sorted by increasing order
        //right to left or end to start
        //find the pair of numbers where a[i] < a[i+1], break decreasing order from right
        
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        if(i >= 0) {
            //find the item, which is just greater than a[i]-th item
            int j = nums.length - 1;
            while(j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        } 
        //since, it is impossible to next lager permutation for descreasing sequence
        //so next permutation as per question is reset to increasing order
        reverseNums(nums, i + 1, nums.length - 1);
        
    }
    
    private void reverseNums(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
