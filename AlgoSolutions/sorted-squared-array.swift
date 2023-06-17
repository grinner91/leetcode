//https://www.algoexpert.io/questions/sorted-squared-array
class Program {

   //O(nlogn)
  func sortedSquaredArray1(_ array: [Int]) -> [Int] {
    return array.map { $0 * $0 }.sorted()
  }
  
  //O(n)
  func sortedSquaredArray2(_ array: [Int]) -> [Int] {
     var sortedArr = Array(repeating: 0, count: array.count)   
        var left = 0
        var right = array.count - 1

        for idx in stride(from: array.count - 1, through: 0, by: -1) {
          if abs(array[left]) > abs(array[right]) {
              sortedArr[idx] = array[left] * array[left]
              left += 1
          } else {
              sortedArr[idx] = array[right] * array[right]
              right -= 1
          }
        }
        
        return sortedArr
  }
}
