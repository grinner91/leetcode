
//https://www.interviewbit.com/problems/maximum-unsorted-subarray/
public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int left = -1;
        int right = -1;

        for(int i = 0; i < A.size() - 1; i++) {
            if(A.get(i) > A.get(i + 1)) {
                left = i;
                break;
            }
        }
        if(left == -1) {
            return new ArrayList<Integer>(Arrays.asList( -1));
        }

        for(int i = A.size() - 1; i > 0; i--) {
            if(A.get(i) < A.get(i - 1) ) {
                right = i;
                break;
            }
        }
        //find min and max within sub-array 
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = left; i <= right; i++) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }

        //find greater than sub-array-min value in left side 
        for(int i = 0; i < left; i++) {
            if(A.get(i) > min) {
                left = i;
                break;
            }
        }
        //find less than sub-array-max value in right side 
        for(int i = A.size() - 1; i >= right ; i--) {
            if(A.get(i) < max) {
                right = i; 
                break;
            }
        }

        return  new ArrayList<Integer>( Arrays.asList( left, right));
    }
}
