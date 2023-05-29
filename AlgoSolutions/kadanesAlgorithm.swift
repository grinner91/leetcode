//https://www.algoexpert.io/questions/kadane's-algorithm

class Program {
//time O(n), space O(1)
 
 func kadanesAlgorithm(array: [Int]) -> Int {
      if array.count == 0 {return -1}
      
      var maxSum = array.first!
      var currentSum = array.first!
      for i in 1..<array.count {
          currentSum = max(array[i], array[i] + currentSum)
           maxSum = max(maxSum, currentSum)
      }
    return maxSum
  }
 
}
