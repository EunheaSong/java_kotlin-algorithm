package algorithm.kotlin.leetcode.medium

class ProductOfArrayExceptSelf {
    /*
    238. Product of Array Except Self
     */

    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var a = 1
        for (i in nums.indices) {
            result[i] = a
            a *= nums[i]
        }
        a = 1
        for (i in nums.indices.reversed()) {
            result[i] *= a
            a *= nums[i]
        }
        return result
    }
}