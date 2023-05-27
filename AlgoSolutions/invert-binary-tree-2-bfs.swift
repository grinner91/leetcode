// class BinaryTree: Equatable {
//   var value: Int?
//   var left: BinaryTree?
//   var right: BinaryTree?
// }

//https://www.algoexpert.io/questions/invert-binary-tree 
//O(n) time, O(n) space 
class Program {
  func invertBinaryTree(tree: BinaryTree?) {
    var queue: [BinaryTree?] = [tree]
    
    while queue.count > 0 {
        let current = queue.removeFirst()
        
        if current == nil { continue }
        
        swapLeftAndRight(current!)
        
        queue.append(current?.left)
        queue.append(current?.right)
    }
 }

  func swapLeftAndRight(_ tree: BinaryTree) {
    let left = tree.left
    tree.left = tree.right
    tree.right = left
}

}
