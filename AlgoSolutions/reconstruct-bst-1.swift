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
        
        let rootVal  = values[0]
        let root = BST(value: rootVal)
        
        //find index for root of right subtree
        var idx = 1
        while idx < values.count && values[idx] < rootVal {
            idx += 1
        }
        
        let leftSubArr = Array(values[1..<idx])
        let rightSubArr = Array(values[idx...])
        
        root.left = leftSubArr.count > 0 ? reconstructBst(leftSubArr) : nil
        root.right =  rightSubArr.count > 0 ? reconstructBst(rightSubArr) : nil
        
        return root
    }

func testReconstructBst() {
    let bst = reconstructBst([10, 4, 2, 1, 5, 17, 19, 18])
    print(bst.value)
}
}
