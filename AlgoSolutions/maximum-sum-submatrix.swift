//https://www.algoexpert.io/questions/maximum-sum-submatrix

class Program {
  
  func maximumSumSubmatrix(_ matrix: [[Int]], _ size: Int) -> Int {
    //calculate sums of matrix 0,0 to i, j
    var sums = createSumMatrix(matrix)
    //calculate max sums from sums matrix
    var maxSubMatrixSum = Int.min
    
    for r in (size - 1)..<matrix.count {
        for c in (size-1)..<matrix[r].count {
            var total = sums[r][c]
            let isTouchTopBorder = r - size < 0
            if !isTouchTopBorder {
                total -= sums[r - size][c]
            }
            let isTouchLeftBorder = c - size < 0
            if !isTouchLeftBorder {
                total -= sums[r][c-size]
            }
            if !(isTouchTopBorder || isTouchLeftBorder) {
                total += sums[r - size][c-size]
            }
            
            maxSubMatrixSum = max(maxSubMatrixSum, total)
        }
    }
    
    return maxSubMatrixSum
  }

func createSumMatrix(_ matrix:[[Int]]) -> [[Int]] {
    var sums = Array(repeating: Array(repeating: 0, count: matrix[0].count), count: matrix.count);
    sums[0][0] = matrix[0][0];
    //sum up 1st row
    for i in 1..<matrix[0].count {
        sums[0][i] = sums[0][i-1] + matrix[0][i];
    }
    //sum up 1st col
    for i in 1..<matrix.count {
        sums[i][0] = sums[i-1][0] + matrix[i][0];
    }
    
    for r in 1..<matrix.count {
        for c in 1..<matrix[r].count {
            sums[r][c] = matrix[r][c] + sums[r-1][c] + sums[r][c-1] - sums[r-1][c-1]
        }
    }
    //print("end of sums")
    return sums;
}

}

/*
time: O(w * h), space O(w*h)

var matrix = [
    [5, 3, -1, 5],
    [-7, 3, 7, 4],
    [12, 8, 0, 0],
    [1, -8, -8, 2]
];

var size = 2
var result = maximumSumSubmatrix(matrix, size)

print("output: \(result)")

*/
