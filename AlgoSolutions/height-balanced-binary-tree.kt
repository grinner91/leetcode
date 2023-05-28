package com.algoexpert.program

//https://www.algoexpert.io/questions/height-balanced-binary-tree
// This is an input class. Do not edit.
open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}


fun heightBalancedBinaryTree(tree: BinaryTree): Boolean {
    val (isBalanced, _) = heightBalancedBinaryTreeRecursion(tree)
    return isBalanced
}

fun heightBalancedBinaryTreeRecursion(tree: BinaryTree?): Pair<Boolean, Int> {
    if (tree == null) {
        return Pair(true, 0)
    }
    if (tree.left == null && tree.right == null) {
        return Pair(true, 1)
    }
    
    val leftInfo = heightBalancedBinaryTreeRecursion(tree.left)
    val rightInfo = heightBalancedBinaryTreeRecursion(tree.right)
    val currentHeight = Math.max(leftInfo.second, rightInfo.second)
    
    if (leftInfo.first && rightInfo.first) {
        if (Math.abs(leftInfo.second - rightInfo.second) <= 1) {
            return Pair(true, currentHeight + 1)
        }
    }
    return Pair(false, currentHeight + 1)
}
