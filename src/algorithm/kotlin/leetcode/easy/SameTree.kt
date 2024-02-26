package algorithm.kotlin.leetcode.easy

class SameTree {
    //100. Same Tree
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

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p?.`val` == null && q?.`val` == null) return true
        if (p?.`val` != q?.`val`) return false
        if (!isSameTree(p?.left, q?.left)) return false
        if (!isSameTree(p?.right, q?.right)) return false
        return true
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}