// class BinaryTree: Equatable {
//   var value: Int?
//   var left: BinaryTree?
//   var right: BinaryTree?
// }

class Program {
  //https://www.algoexpert.io/questions/invert-binary-tree
  //O(n) time, O(n) space 
  
  func invertBinaryTree(tree: BinaryTree?) {
    let invertTree = invertBinaryTreeRecursion(tree: tree)
    tree?.left = invertTree?.left
    tree?.right = invertTree?.right
 }

func invertBinaryTreeRecursion(tree: BinaryTree?) -> BinaryTree? {
    if tree == nil {
        return nil
    }
    let leftSubTree: BinaryTree? = invertBinaryTreeRecursion(tree: tree?.left)
    let rightSubTree: BinaryTree? = invertBinaryTreeRecursion(tree: tree?.right)
    
    tree?.left = rightSubTree
    tree?.right = leftSubTree
  return tree 

 }


}
