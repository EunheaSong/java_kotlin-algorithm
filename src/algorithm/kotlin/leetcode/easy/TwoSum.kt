package algorithm.kotlin.leetcode.easy

class TwoSum {
    /*
    1. Two sum
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        nums.forEachIndexed { i, num ->
            for (j in i+1..< nums.size) {
                if (num + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return IntArray(2)
    }

    fun twoSum2(nums: IntArray, target: Int): IntArray {
        val map: HashMap<Int, Int> = hashMapOf()
        nums.forEachIndexed { i, num ->
            if (map.containsKey(target - num)) return intArrayOf(map[target-num]!!, i)
            map[num] = map.getOrDefault(num, i)
        }
        return intArrayOf()
    }


}