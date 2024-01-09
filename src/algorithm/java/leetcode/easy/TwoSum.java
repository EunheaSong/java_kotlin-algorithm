package algorithm.java.leetcode.easy;

import java.sql.Array;
import java.util.Arrays;

public class TwoSum {
    /*
//        int[] nums = {2,7,11,15};
//        int target = 9;
        int[] nums = {2,5,5,11};
        int target = 10;
        TwoSum ts = new TwoSum();
        System.out.println(Arrays.toString(ts.twoSum(nums, target)));

    1. Two Sum
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]

    Example 3:
    Input: nums = [3,3], target = 6
    Output: [0,1]

    Constraints:
    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.
     */

    public int[] twoSum(int[] nums, int target) {
        //배열 중 두 가지 값을 더하면 타켓 값이 되는 인덱스 숫자를 배열에 담아서 리턴.
        int[] a = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (n + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return a;
    }
}
