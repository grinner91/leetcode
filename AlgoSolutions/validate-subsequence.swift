class Program {
 
//https://www.algoexpert.io/questions/validate-subsequence
//O(n) time, O(1) space
static func isValidSubsequence(_ array: [Int], _ sequence: [Int]) -> Bool {
    var arrIdx = 0
    var seqIdx = 0
    while seqIdx < sequence.count && arrIdx < array.count {
        if sequence[seqIdx] == array[arrIdx] { seqIdx += 1 }
        arrIdx += 1
    }
    return seqIdx == sequence.count 
}


// func testValidSubSequence() {
//     print(isValidSubsequence([5, 1, 22, 25, 6, -1, 8, 10], [1, 6, -1, 10]))
// }

}
