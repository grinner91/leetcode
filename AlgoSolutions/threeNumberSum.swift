class Program {
 //https://www.algoexpert.io/questions/three-number-sum

func threeNumberSum(array: inout [Int], targetSum: Int) -> [[Int]] {
    var tiplets = [[Int]]()
    
    let sortedArr = array.sorted() //O(nlogn)
    for i in 0..<sortedArr.count-2 { //O(n * n )
        var left = i + 1;
        var right = sortedArr.count - 1
        while left < right  {
            let currentSum = sortedArr[i] + sortedArr[left] + sortedArr[right]
            if currentSum == targetSum {
                tiplets.append([sortedArr[i], sortedArr[left], sortedArr[right]])
                left += 1
                right -= 1
                //print(i, ", ", left, ", ",right)
            } else if currentSum < targetSum {
                left += 1;
            } else {
                right -= 1;
            }
        }
    }
    return tiplets
}

func testThreeNumbersum() {
    var arr = [12, 3, 1, 2, -6, 5, -8, 6]
    print("resut: ")
    print(threeNumberSum( array: &arr , targetSum: 0));
}

}
