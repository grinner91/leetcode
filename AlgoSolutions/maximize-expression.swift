class Program {

//https://www.algoexpert.io/questions/maximize-expression
/*
 hints:
  - for given int array and find maximize expression value 
  - maxExp = arr[i] - arr[j] + arr[k] - arr[l]
  -- i < j < k < l indices
  --- max exp: if 1. A, 2. A - B, 3. A-B+C, 4. A-B+C-D are maximize in each step 

  time: O(n) //O(4n)
  space: O(n) //4n
 */

func maximizeExpression(_ array: [Int]) -> Int {
  
    if array.count < 4 {return 0}
  
    var maxArrA = Array(repeating: Int.min, count: array.count)
    var maxArrAB = Array(repeating: Int.min, count: array.count)
    var maxArrABC = Array(repeating: Int.min, count: array.count)
    var maxArrABCD = Array(repeating: Int.min, count: array.count)
  
    //init value
    maxArrA[0] = array[0];
  
    //find max value for A
    for i in 1..<array.count {
        maxArrA[i] = max(maxArrA[i-1], array[i])
    }
  
    //find  max values A - B
    for i in 1..<array.count {
        let result = maxArrA[i-1] - array[i]
        maxArrAB[i] = max(maxArrAB[i-1], result)
    }
    
    //find max values for A-B+C
    for i in 2..<array.count {
        let result = maxArrAB[i-1] + array[i]
        maxArrABC[i] = max(maxArrABC[i-1], result)
    }
    
    //find max values for A-B+C-D
    for i in 3..<array.count {
        let result = maxArrABC[i-1] - array[i]
        maxArrABCD[i] = max(maxArrABCD[i-1], result)
    }
    
    return maxArrABCD[array.count - 1]
  }

func testMaximizeExpression() {
    print(maximizeExpression([3, 6, 1, -3, 2, 7]))
  //output: 4
}

}
