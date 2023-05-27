class Program {
  // This is an input class. Do not edit.
  class BinaryTree {
    var value: Int
    var left: BinaryTree?
    var right: BinaryTree?
    var parent: BinaryTree?

    init(value: Int) {
      self.value = value
      left = nil
      right = nil
      parent = nil
    }
  }
//https://www.algoexpert.io/questions/find-successor
 //O(h) time, O(1) space
    func findSuccessor(_ tree: BinaryTree, _ node: BinaryTree) -> BinaryTree? {
        if node.right != nil {
            return getLeftmostChild(node.right!)
        }
        return getRighmostParent(node)
    }
    
    func getLeftmostChild(_ node: BinaryTree) -> BinaryTree {
        var current = node
        while current.left != nil {
            current = current.left!
        }
        return current
    }
    
    func getRighmostParent(_ node: BinaryTree) -> BinaryTree? {
        var current = node
        while current.parent != nil && current.parent!.right === current {
            current = current.parent!
        }
        return current.parent
    }
   
}
