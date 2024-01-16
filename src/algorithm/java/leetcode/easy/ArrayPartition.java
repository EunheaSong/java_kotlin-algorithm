package algorithm.java.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayPartition {
    /*
            int[] nums = {1,4,3,2};
        ArrayPartition ap = new ArrayPartition();
        System.out.println(ap.arrayPairSum(nums));

    561. Array Partition

    Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.

    Example 1:
    Input: nums = [1,4,3,2]
    Output: 4
    Explanation: All possible pairings (ignoring the ordering of elements) are:
    1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
    2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
    3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
    So the maximum possible sum is 4.

    Example 2:
    Input: nums = [6,2,6,5,1,2]
    Output: 9
    Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.

    Constraints:
    1 <= n <= 104
    nums.length == 2 * n
    -104 <= nums[i] <= 104
     */

    /*
    오름차순으로 정렬하여 순서대로 두개씩 묶으면 요구사항에 맞는 계산이 된다.
    -> 1,2,3,4 -> min(1,2) + min(3,4) -> 1 + 3 = 4
    -> 1,2,2,5,6,6 -> min(1,2) + min(2,5) + min(6,6) -> 1 + 2 + 6 = 9
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int a = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            a += Math.min(nums[i*2], nums[i*2+1]);
        }
        return a;
    }
    public static class BookAnswer {

        public int arrayPairSum(int[] nums) {
            int sum = 0;
            List<Integer> pair = new ArrayList<>();
            Arrays.sort(nums);
            for (int n : nums) {
                pair.add(n);
                if (pair.size() == 2) {
                    sum += Collections.min(pair);
                    pair.clear();
                }
            }
            return sum;
        }

        public int arrayPairSum2(int[] nums) {
            int sum = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0) sum += nums[i];
            }
            return sum;
        }
    }

    public static class LeetCodeFestestAnswer {

        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            int i = 0;
            int size = nums.length - 1;
            while (i < size) {
                sum += nums[i];
                i += 2;
            }
            return sum;
        }
    }
}
