package algorithm_quiz.java.leetcode.easy;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public int[] twoSum(int[] nums, int target) { // 32ms
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

    public static class BookAnswer {

        //브루트 포스 방식.
        public int[] twoSum(int[] nums, int target) { // 45ms
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]
                            {i, j};
                    }
                }
            }
            //항상 정답이 존재하므로 null 이 리턴될 경우는 없다.
            return null;
        }

        /*
        위의 방식은 O(n2) 이 소요된다.
        map 을 사용해서 보다 빠르게 수행가능한 방법을 구현해본다.
        */
        public int[] twoSum2(int[] nums, int target) { // 4ms
            Map<Integer, Integer> numsMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                numsMap.put(nums[i], i);
            }

            for (int i = 0; i < nums.length; i++) {
                if (numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i])) {
                    return new int[]{i, numsMap.get(target - nums[i])}; // 그냥 i, target - nums[i] 를 하면 안되나?
                }
            }
            return null;
        }

        //하나의 for 문으로 합치기
        public int[] twoSum3(int[] nums, int target) { // 2ms
            Map<Integer, Integer> numsMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (numsMap.containsKey(target - nums[i])) {
                    return new int[]{numsMap.get(target - nums[i]), i}; // 그냥 i, target - nums[i] 를 하면 안되나?
                }
                numsMap.put(nums[i], i);
            }
            return null;
        }

        /*
        만약, 인덱스 값을 반환하는 문제가 아니라 값을 반환하는 문제였다면,
        투포인터를 활용해서 구현할 수도 있었을 것이다.
        하지만 투포인터를 효율적으로 활용하기 위해서는 포인터를 이동시킬만한 규칙이 필요한데
        해당 문제에서 숫자를 가지고 줄 수 있는 규칙이라면,
        투포인터의 두 값을 더한 값이 target 값보다 작으면 우측으로 이동, 크면 좌측으로 이동.
        같은 식의 규칙을 줄 수 있다. 하지만 해당 규칙은 배열에 대한 정렬이 필요하다.
        배열을 정렬하게 되면 문제에서 반환값으로 요구하는 인덱스 정보를 알 수 없다.
        어떻게 저쩌게하면 다 방법은 있겠지만, 결국 방법이 복잡해지고 투포인터를 사용하는 의미가 무색해진다.

       * 투포인터는 배열이 나오는 문제에서 유용하게 사용할 수 있지만, 포인터를 움직일 수 있는 조건을 적절히 지정가능할 때 사용하자!
         */
    }
}
