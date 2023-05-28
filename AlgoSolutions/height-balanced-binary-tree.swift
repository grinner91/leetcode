//https://www.algoexpert.io/questions/height-balanced-binary-tree

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
  func heightBalancedBinaryTree(_ tree: BinaryTree) -> Bool {
      let treeInfo = heightBalancedBinaryTreeRecursion(tree)
      return treeInfo.isBalanced
  }
    func heightBalancedBinaryTreeRecursion(_ tree: BinaryTree?) -> (isBalanced: Bool, height: Int) {
        if tree == nil {
            return (true, 0)
        }
        
        if tree?.left == nil && tree?.right == nil
        {
            return (true, 1)
        }
        
        let leftInfo = heightBalancedBinaryTreeRecursion(tree?.left)
        let rightInfo = heightBalancedBinaryTreeRecursion(tree?.right)
        let currentHeight = max(leftInfo.height, rightInfo.height) + 1
        
        if leftInfo.isBalanced && rightInfo.isBalanced {
            if abs(leftInfo.height - rightInfo.height) <= 1 {
                return (true, currentHeight )
            }
        }
        
        return (false, currentHeight)
    }
}
