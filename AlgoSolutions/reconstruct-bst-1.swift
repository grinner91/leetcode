class Program {
 //https://www.algoexpert.io/questions/reconstruct-bst
// This is an input class. Do not edit.
class BST {
    var value: Int
    var left: BST?
    var right: BST?
    
    init(value: Int) {
        self.value = value
        left = nil
        right = nil
    }
}

func reconstructBst(_ values: [Int]) -> BST {

    var rootVal  = values[0]
    var root = BST(value: rootVal)
    
    var leftSubArr = [Int]()
    var idx = 1
    while idx < values.count && values[idx] < rootVal {
        leftSubArr.append(values[idx])
        idx += 1
        
    }
    
    var rightSubArr = [Int]()
    while idx < values.count {
        rightSubArr.append(values[idx])
        idx += 1
    }
 
    root.left = leftSubArr.count > 0 ? reconstructBst(leftSubArr) : nil
    root.right =  rightSubArr.count > 0 ? reconstructBst(rightSubArr) : nil
    
    return root
}


func testReconstructBst() {
    let bst = reconstructBst([10, 4, 2, 1, 5, 17, 19, 18])
    print(bst.value)
}



}
