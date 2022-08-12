//https://www.algoexpert.io/questions/three-number-sum

import java.util.*;
/*
input: [12, 3, 1, 2, -6, 5, -8, 6]
target sum: 0

output: 
[
  [-8, 2, 6],
  [-8, 3, 5],
  [-6, 1, 5]
]

*/
class Program {
  public static List<Integer[]> threeNumberSum(int[] array, int target) {
    //sort array - n*log(n)
  
    Arrays.sort(array);
    List<Integer[]> triplets = new ArrayList<>();

    for(int current  = 0; current < array.length - 2; current++) {
       int left = current + 1;
       int right = array.length - 1; 
      
      while(left < right) {
         int sum = array[left] + array[current] + array[right];
         if(sum == target) {
           triplets.add(new Integer[]{ array[current], array[left], array[right] });
           left++;
           right--;
         } else if (sum < target) {
           left++;
         } else {
           right--;
         }
       }
    }
    
    return triplets;
  }
}
