package algorithm.java.leetcode.medium;

import java.util.*;

public class FindPolygonWiththeLargestPerimeter {
    /*
    2971. Find Polygon With the Largest Perimeter
    */

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long answer = 0;
        long q= 0;
        for(int i=0;i<nums.length;i++){
            q = q+nums[i];   
        }
        /*
            long q = Arrays.stream(nums)
                    .mapToLong(n -> n)
                    .sum();
            이렇게 스트림을 사용하는 것보다 
            반복문 돌리는게 속도가 쬐금 더 빠르다. 8~9ms 정도...
        */
        for (int i = nums.length-1; i >= 0; i--) {
            if (q - nums[i] <= nums[i]) {
                if (nums.length == 3) return -1; 
                q-=nums[i];
            }
        }
        return (q == 0) ? -1 : q;
    }

    public static class OtherPeopleAnswer {
        public long largestPerimeter(int[] nums) {
            Arrays.sort(nums);
            long sum = 0;
            long ans = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < sum) {
                    ans = nums[i] + sum;
                }
                sum += nums[i];
            }
            return ans;
        }
    }
}
