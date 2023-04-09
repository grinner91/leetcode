import java.util.*;

class Program {

/*
https://www.algoexpert.io/questions/knapsack-problem
Hints: 
- maximized combined value of the items, and within capacity 
sample input: 
{
  "items": [
    [1, 2],
    [4, 3],
    [5, 6],
    [6, 7]
  ],
  "capacity": 10
}
sample output:  [10, [1, 3]] 
// total value and indexes of items. [4,3], [6, 7]
*/

/*
time: O(nc) where n items, c capacity 
space: O(nc)
*/
  
  public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
  
    var values = new int[items.length + 1][capacity+1];

    //time: O(n^2)
    for(int i = 1; i <= items.length; i++) {
       var v = items[i-1][0];
       var w = items[i-1][1];
      for(int c = 1; c <= capacity; c++) {
        if( w <= c ) {
          values[i][c] = Math.max(v + values[i-1][c - w], values[i-1][c]);
          
        } else {
          values[i][c] = values[i-1][c];
        }
      }
    }

    return buildSequence(items, values, capacity);
  }

  private static List<List<Integer>> buildSequence(int[][] items, int[][] values, int capacity) {
    var finalItems = new ArrayList<Integer>();
    var idx = values.length - 1; 
    var cap = capacity;

    while(idx > 0 && cap > 0) {
      if(values[idx][cap] != values[idx-1][cap]) {
         finalItems.add(0, idx-1);
         cap -= items[idx - 1][1];
      } 
      idx--;
    }

    var totalValue = Arrays.asList(values[items.length][capacity]);
    var result = new ArrayList<List<Integer>>();
    
    result.add(totalValue);
    result.add(finalItems);
    
    return result;
  }
}
