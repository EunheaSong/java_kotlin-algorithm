package algorithm_quiz.kotlin.leetcode.easy

class SearchInsertPosition {
    /*
    35. Search Insert Position
     */

    fun searchInsert(nums: IntArray, target: Int): Int {
        nums.forEachIndexed { index, num ->
            if (target < num || num == target) return index
            else if (
                index == nums.size-1 ||
                nums[0] < target && target < nums[index + 1]
            ) return index + 1
        }
        return -1
    }

}