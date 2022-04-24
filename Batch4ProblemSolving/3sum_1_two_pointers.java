//15. 3Sum
//https://leetcode.com/problems/3sum/
//solution: Two pointer approach
//ref: leetcode solutions 

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //step: handle edge cases 
      
        List<List<Integer>> result = new ArrayList<>();
    
        int n = nums.length;
        //step: sort nums 
        Arrays.sort(nums);
        
        //step: find triplets, consider i-th and other 2 sum 
        for(int i = 0; i < n && nums[i] <= 0; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                findTriplets(nums, i, result);
            }
        }
        
        return result;
    }
    
    private void findTriplets(int[] nums, int i, List<List<Integer>> result) {
        int low = i + 1;
        int high = nums.length - 1;
        
        while(low < high) {
            int sum = nums[i] + nums[low] + nums[high];
             //since, nums is sorted, if sum < 0, then move towards high 
            if(sum < 0) {
                low++;
             //since, nums is sorted, if sum > 0, then move towards low
            } else if( sum > 0) {
                high--;
            } else {
                //sum == 0, add triplets to result 
                result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                low++;
                high--;
                //skip duplicates in this pass for i 
                while(low < high && nums[low - 1] == nums[low]) {
                    low++;
                }
            }
        }
    }
}
