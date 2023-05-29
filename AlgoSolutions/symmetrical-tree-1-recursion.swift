//https://www.algoexpert.io/questions/symmetrical-tree
class ProgramSymetriRecursion {
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
    
    func symmetricalTree(_ tree: BinaryTree) -> Bool {
        return symetricalTreeRecursion(tree.left, tree.right)
    }
    
    func symetricalTreeRecursion(_ left: BinaryTree?, _ right: BinaryTree? ) -> Bool {
        
        if left == nil && right == nil { return true }
        else if left?.value != right?.value { return false }
        
        let leftSymetri =  symetricalTreeRecursion(left?.left, right?.right)
        
        let rightSymetri =  symetricalTreeRecursion(left?.right, right?.left)
        
        return leftSymetri && rightSymetri
    }
}
