
//Disk Stacking 
//https://www.algoexpert.io/questions/disk-stacking
/*
Dynamic programming: 

Hints:
- given disks dimentions [width, depth, height]
- goals is to stack disks to attain maximum heights 
- a disks is strictly smaller  in dimentions than below it 

sample input: [[2, 1, 2],[3, 2, 3],[2, 2, 8], [2, 3, 4],[1,3,1], [4,4,5]]
sample output [[2, 1, 2],[3, 2, 3], [4,4,5]] //10 === 2 + 3 + 5 hieghts 

*/

import java.util.*;

class Program {

  //total time: O(n^2)
  //space: O(n)
  public static List<Integer[]> diskStacking(List<Integer[]> disks) {
    //sorte disks according to heights 
    //time: O(nlogn)
    disks.sort((d1, d2) -> d1[2].compareTo(d2[2])); 
    //dp init max hieghts 
    var heights = new int[disks.size()];
    for(int i = 0; i < disks.size(); i++) {
      heights[i] = disks.get(i)[2];
    }

    //time: O(n)
    //sequence path 
    var seqs = new int[disks.size()];
    for(int i = 0; i < disks.size(); i++) {
      seqs[i] = Integer.MIN_VALUE;
    }
    //time: O(n^2)
    //dp to update heights 
    var maxHIndex = 0;
    for(int i = 1; i < disks.size(); i++) {
      var curr = disks.get(i);
      for(int j = 0; j < i; j++) {
        var other = disks.get(j);
        if(isValidDimention(curr, other)) {
          if(curr[2] + heights[j] > heights[i]) {
            heights[i] = curr[2] + heights[j];
            seqs[i] = j;
          }
        }
      }
      //keep track of max Height Index
      if(heights[i] >= heights[maxHIndex]) {
        maxHIndex = i;
      }
    }

    //build sequence / path
    
    return buildSequence(disks, seqs, maxHIndex);
  }

  private static boolean isValidDimention(Integer[] c, Integer[] o) {
    return o[0] < c[0] && o[1] < c[1] && o[2] < c[2];
  }

  private static List<Integer[]> buildSequence(List<Integer[]> disks, int[] seqs, int currentIdx) {
    var result = new ArrayList<Integer[]>();
    //time: O(n)
    while(currentIdx != Integer.MIN_VALUE) {
      result.add(0, disks.get(currentIdx));
      currentIdx = seqs[currentIdx];
    }
    return result;
  }
}
