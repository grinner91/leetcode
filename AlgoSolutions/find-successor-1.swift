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
  //time O(n), space O(n)
  func findSuccessor(_ tree: BinaryTree, _ node: BinaryTree) -> BinaryTree? {
      var nodes =  [BinaryTree]()
      traverseNodesRecursion(tree, &nodes)
      
      for i in 0..<nodes.count-1 {
          if node.value == nodes[i].value {
              return nodes[i+1]
          }
      }
      
    return nil
  }
    
    func traverseNodesRecursion(_ tree: BinaryTree, _ nodes: inout [BinaryTree]) {
        if let left = tree.left { traverseNodesRecursion(left, &nodes) }
        nodes.append(tree)
        if let right = tree.right { traverseNodesRecursion(right, &nodes) }
    }
}
