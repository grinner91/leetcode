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

 func mergeBinaryTrees(_ tree1: BinaryTree?, _ tree2: BinaryTree?) -> BinaryTree? {
        if tree1 == nil {
            return tree2
        }
        
        var stack1 = [tree1]
        var stack2 = [tree2]
        
        while stack1.count > 0 {
            
             let node1 = stack1.popLast()!
      
            
             let node2 = stack2.popLast()!
            if node2 == nil { continue }
            
            node1!.value += node2!.value
            
            if node1!.left == nil {
                node1!.left = node2!.left
            } else {
                stack1.append(node1!.left)
                stack2.append(node2!.left)
            }
            
            if node1!.right == nil {
                node1!.right = node2!.right
            } else {
                stack1.append(node1!.right)
                stack2.append(node2!.right)
            }
        }
        
        return tree1
    }
}
