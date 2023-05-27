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

 //https://www.algoexpert.io/questions/binary-tree-diameter
  //O(n) time, O(h) space 
  
  func binaryTreeDiameter(_ tree: BinaryTree) -> Int {
     var tuple = binaryTreeDiameterRecursion(tree)
      return tuple.diameter
  }

func binaryTreeDiameterRecursion(_ tree: BinaryTree?) -> (diameter: Int, height: Int) {
    guard let tree = tree else { return (0, 0) }
    
    let leftInfo = binaryTreeDiameterRecursion(tree.left)
    let rightInfo = binaryTreeDiameterRecursion(tree.right)
    
    let currentMaxHeight = max(leftInfo.height, rightInfo.height)
    let currentDiameter = leftInfo.height + rightInfo.height
    let maxDiameter = max(currentDiameter, leftInfo.diameter, rightInfo.diameter)
  
    //adds root node height: 1 +  max of left, right subtree
    return (maxDiameter, currentMaxHeight + 1)
}
}
