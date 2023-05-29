//https://www.algoexpert.io/questions/split-binary-tree
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

     
    //time O(n), space O(n)
    func splitBinaryTree(_ tree: BinaryTree) -> Int {
        var nodesSum = Set<Int>()
        let total = calculateNodesSum(tree, &nodesSum)
        if total % 2 != 0 { return 0 }
        let subTotal = total / 2
        
        if nodesSum.contains(subTotal) {
            return subTotal
        }
        
        return 0
    }
    
    func calculateNodesSum(_ node: BinaryTree?, _ nodesSum: inout Set<Int>) -> Int {
        if node == nil { return 0 }
        
        let currentSum = node!.value
        + calculateNodesSum(node?.left, &nodesSum)
        + calculateNodesSum(node?.right, &nodesSum)
        
        nodesSum.insert(currentSum)
        
        return currentSum
    }

}
