//https://www.algoexpert.io/questions/kadane's-algorithm

class Program 
//time O(n), space O(1)
 func kadanesAlgorithm(array: [Int]) -> Int {
      if array.count == 0 {return -1}
      
      var maxSum = array.first!
      var currentMax = array.first!
      for i in 1..<array.count {
           currentMax = max(array[i], array[i] + currentMax)
           maxSum = max(maxSum, currentMax)
      }
    return maxSum
  }
}
