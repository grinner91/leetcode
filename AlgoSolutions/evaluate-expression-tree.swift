
//https://www.algoexpert.io/questions/evaluate-expression-tree

import Foundation
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
    
    func evaluateExpressionTree(_ tree: BinaryTree) -> Int {
        // Write your code here.
        return evaluate(tree)
    }
    
    private func  evaluate( _ tree: BinaryTree) -> Int {
        if(tree.value > 0) { return tree.value}
        
        let leftValue = evaluate(tree.left!)
        let rightValue = evaluate(tree.right!)
        
        let oper = tree.value;
        switch oper {
        case -1:
            return leftValue + rightValue
        case -2:
            return leftValue - rightValue
        case -3:
            return leftValue / rightValue
        case -4:
            return leftValue * rightValue
        default:
            return 0
        }
        
    }
}

//
func testEvaluateExpressionTree() {
    let tree = Program.BinaryTree(value: -1)
    tree.left = Program.BinaryTree(value: 2)
    tree.right = Program.BinaryTree(value: -2)
    tree.right!.left = Program.BinaryTree(value: 5)
    tree.right!.right = Program.BinaryTree(value: 1)
    let expected = 6
    var actual = Program().evaluateExpressionTree(tree)
    print(actual)
    
}
