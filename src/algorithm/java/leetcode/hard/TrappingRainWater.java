package algorithm.java.leetcode.hard;

import java.util.Arrays;

public class TrappingRainWater {
    /*
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] height = {4,2,0,3,2,5};
//        int[] height = {4,2,3};
//        int[] height = {2,0,2};

    TrappingRainWater trw = new TrappingRainWater();
    System.out.println(trw.trap(height));

     42. Trapping Rain Water

    Given n non-negative integers representing an elevation map where the width of each bar is 1,
    compute how much water it can trap after raining.

    Example 2:
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

    Example 2:
    Input: height = [4,2,0,3,2,5]
    Output: 9

    Constraints:
    n == height.length
    1 <= n <= 2 * 104
    0 <= height[i] <= 105

    */

    public void pointer(int[] height, int i, int j) {

    }

    public int trap(int[] height) { // 0ms !!! HAHAHAHAHAHA
        //투포인터 사용.
        //최댓값 먼저 찾기.
        //최댓값을 만날 때까지 이동. 최댓값을 만나면 다음 포인터가 이동.
        //이동중 만나는 최댓값 찾기.
        int max = 0;
        for (int h : height) {
            max = Math.max(max, h);
        }

        int number = 0;
        int m = 0;
        //좌 -> 우 로 이동하는 포인터 1.
        for (int i = 0; i < height.length; i++) {
            if (m > height[i]) {
                number += m - height[i];
            } else {
                m = height[i];
            }
            if (max <= m) {
                m = 0;
                //우 -> 좌 로 이동하는 포인터 2.
                for (int j = height.length -1; j > i; j--) {
                    if (m > height[j]) {
                        number += m - height[j];
                    } else {
                        m = height[j];
                    }
                }
                break;
            }
        }

        return number;
    }
}
