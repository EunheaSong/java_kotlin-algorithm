package algorithm_quiz.java.leetcode.medium;

public class ProductOfArrayExceptSelf {
     /*
    238. Product of Array Except Self
     */

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int a = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = a;
            a *= nums[i];
        }
        a = 1;
        for (int i = nums.length-1; 0 <= i; i--) {
            result[i] *= a;
            a *= nums[i];
        }
        return result;
    }
}
