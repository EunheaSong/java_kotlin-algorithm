package algorithm.java.leetcode.medium;

import java.util.*;

public class ThreeSum {
    /*
    //        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {0,0,0,0};
        int[] nums = {-2,0,1,1,2};
        ThreeSum.BookAnswer ts = new ThreeSum.BookAnswer();
        System.out.println(ts.threeSum(nums));

    15. 3Sum

    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    Notice that the solution set must not contain duplicate triplets.

    Example 1:
    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Explanation:
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    The distinct triplets are [-1,0,1] and [-1,-1,2].
    Notice that the order of the output and the order of the triplets does not matter.

    Example 2:
    Input: nums = [0,1,1]
    Output: []
    Explanation: The only possible triplet does not sum up to 0.

    Example 3:
    Input: nums = [0,0,0]
    Output: [[0,0,0]]
    Explanation: The only possible triplet sums up to 0.

    Constraints:
    3 <= nums.length <= 3000
    -105 <= nums[i] <= 105
     */

    public List<List<Integer>> threeSum(int[] nums) {
        //세가지 값을 더 해서 0 이 되는 모든 경우의 수 찾기.
        //세가지 값의 객체는 모두 다름 (인덱스가 다 다름)
        List<List<Integer>> answer = new ArrayList<>();
//        List<Integer> addToZero = new ArrayList<>(3);
//        Map<Integer, Integer> numsToMap = new HashMap<>();
        Arrays.sort(nums);
        int a = 106;
        int b = 106;
        int c = 106;
        int x = 1;
        for (int i = 0; i < nums.length -1; i++) {
            int n = (nums[i]) + (nums[i + 1]);
            System.out.println(nums[i]);
            for (int j = i + 2; j < nums.length; j++) {
//                if (i == j || i + 1 == j) continue;
                if (n + (nums[j]) == 0 &&
                    !(a == nums[i] && b == nums[i + 1] && c == nums[j])) {
//                    if (a == nums[i] && b == nums[i + 1] && c == nums[j]) continue;
                    List<Integer> addToZero = new ArrayList<>(3);
                    addToZero.add(nums[i]);
                    addToZero.add(nums[i + 1]);
                    addToZero.add(nums[j]);
                    a = nums[i];
                    b = nums[i + 1];
                    c = nums[j];
                    answer.add(addToZero);
                    break;
                }
            }

        }
        return answer;
    }

    public static class BookAnswer {

        //투포인터 사용.
        public List<List<Integer>> threeSum(int[] nums) {
            int left, right, sum;
            List<List<Integer>> results = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length -2; i++) {
                //중복된 값 건너뛰기
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                //간격을 좁혀 가며 합 (sum) 계산.
                left = i + 1;
                right = nums.length - 1;
                while (left < right) {
                    sum = nums[i] + nums[left] + nums[right];
                    //합이 0보다 작다면 왼쪽 포인터 이동;
                    if (sum < 0) left += 1;
                        //합이 0보다 크면 오른쪽 포인터 이동.
                    else if (sum > 0) right -= 1;
                    else {
                        //합이 0인 경우이므로 정답 처리
                        results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        //중복된 값 건너뛰기, 이 처리를 하지 않으면 같은 정답이 두 번 나올 수 있다.
                        while (left < right && nums[left] == nums[left + 1])
                            left += 1;
                        while (left < right && nums[right] == nums[right - 1])
                            right -= 1;
                        //정답이 나왔으므로 투 포인터 모두 한 칸씩 이동.
                        //합이 0인 상황이므로 양쪽 모두 이동해야한다.
                        left += 1;
                        right -= 1;
                    }
                }
            }
            return results;
        }
    }
}
