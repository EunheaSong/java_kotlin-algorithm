package algorithm.kotlin.leetcode.easy

class DiameterOfBinaryTree {
    /*
    543. Diameter of Binary Tree
     */

    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    var i = 0
    var bigest = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        i++
        var addLeft = 0
        var addRight = 0
        if (root?.left != null) {
            addLeft++
            addLeft += diameterOfBinaryTree(root.left)
        }
        if (root?.right != null) {
            addRight++
            addRight += diameterOfBinaryTree(root.right)
        }
        i--
        bigest = maxOf(bigest, addLeft + addRight)
        return if (i != 0) maxOf(addLeft, addRight)
        else bigest
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
