/https://www.algoexpert.io/questions/symmetrical-tree

class Program {
  // This is an input class. Do not edit.
  class BinaryTree {
    var value: Int
    var left: BinaryTree?
    var right: BinaryTree?

    init(value: Int) {
      self.value = value
      left = nil
      right = nil
    }
  }
 //O(n) time, O(h) space 
  func symmetricalTree(_ tree: BinaryTree) -> Bool {
        
        var leftStack = [tree.left]
        var rightStack = [tree.right]
        
        while !leftStack.isEmpty {
            let leftNode = leftStack.popLast()!
            let rightNode = rightStack.popLast()!
            
            if leftNode == nil && rightNode == nil { continue }
            
            if leftNode == nil || rightNode == nil
                || leftNode!.value != rightNode!.value {
                return false
            }
            
            leftStack += [leftNode?.left, leftNode?.right]
            rightStack += [rightNode?.right, rightNode?.left]
        }
       
        return true
    }
}
