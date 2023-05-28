//https://www.algoexpert.io/questions/merge-binary-trees
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
 func mergeBinaryTrees(_ tree1: BinaryTree?, _ tree2: BinaryTree?) -> BinaryTree? {
    return mergeBinaryTreesRecursion(tree1, tree2)
  }
    
    func mergeBinaryTreesRecursion(_ tree1: BinaryTree?, _ tree2: BinaryTree?) -> BinaryTree? {
        if tree1 == nil && tree2 == nil {
            return nil
        }
        
        let node = BinaryTree(value: (tree1?.value ?? 0) + (tree2?.value ?? 0))
        node.left = mergeBinaryTreesRecursion(tree1?.left ?? nil , tree2?.left ?? nil)
        node.right = mergeBinaryTreesRecursion(tree1?.right ?? nil , tree2?.right ?? nil)
        
      return node
    }
}
