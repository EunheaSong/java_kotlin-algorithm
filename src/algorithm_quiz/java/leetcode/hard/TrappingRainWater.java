package algorithm_quiz.java.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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

    public static class BookAnswer {

        // 투 포인터 사용.
        public int trap(int[] height) { // 1ms
            int volume = 0;
            int left = 0;
            int right = height.length -1;
            int leftMax = height[left];
            int rightMax = height[right];

            //투 포인터가 서로 겹칠 때까지 반복한다.
            while (left < right) {
                leftMax = Math.max(height[left], leftMax);
                rightMax = Math.max(height[right], rightMax);

                //더 높은 쪽을 향해 투 포인터 이동
                if (leftMax <= rightMax) {
                    //왼쪽 막대 최대 높이와의 차이를 더하고 왼쪽 포인터 이동
                    volume += leftMax - height[left];
                    left += 1;
                } else {
                    //오른쪽 막대 최대 높이와의 차이를 더하고 오른쪽 포인터 이동
                    volume += rightMax - height[right];
                    right -= 1;
                }
            }
            return volume;
        }

        //스택 사용
        public int trap2(int[] height) { //3ms
            Deque<Integer> stack = new ArrayDeque<>();
            int volume = 0;

            for (int i = 0; i < height.length; i++) {
                //변곡점을 만나는 경우
                //스택이 비어있지 않고, 현재가 이전 값보다 클때.
                //peek 은 pop 과 다르게 값을 조회만한다. 인덱스 0 번째 값을 조회해온다.
                //push 로 삽입했기 때문에 가장 최근에 들어간 값이 조회된다.
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    System.out.println("height[i] : " + height[i] + " height[stack.peek()] : "+ height[stack.peek()]);

                    //pop 은 stack 에서 값을 삭제하며 꺼내온다. 인덱스 0 번째 값을 가져온다.
                    //push 로 삽입했기 때문에 가장 최근에 들어간 값이 조회된다.
                    Integer top = stack.pop();
                    System.out.println("top : " + top);
                    // i == 2 일 경우, 이전 값보다 크다고 하여도 무시되기 무시되기 때문에 다음으로 넘긴다.
                    if (stack.isEmpty()) {
                        break;
                    }
                    //스택의 마지막 위치까지를 거리로 계산
                    int distance = i - stack.peek() -1; // 3 -1 -1 -> 1
                    System.out.println("distance: " + i + " / "+ stack.peek() + " / " + 1);

                    //현재 높이 또는 스택의 마지막 위치 높이 중 낮은 값에 방금 꺼낸 높이의 차이를 물 높이로 지정
                    int water = Math.min(height[i], height[stack.peek()]) - height[top];
                    System.out.println("height[i] : " + height[i] + " height[stack.peek()] : " +height[stack.peek()] + " height[top] : " + height[top]);
                    // 물이 쌓이는 양은 거리와 물 높이의 곱
                    volume += distance * water;
                    System.out.println("volume : " + volume + " distance : " +distance+  " water : " + water);
                }
                //push() 하면 0 번째 인덱스로 저장된다. 기존값들은 한 칸씩 밀림. (add 는 차례대로 저장.)
                //인덱스 값을 저장.
                stack.push(i);
                System.out.println("stack.push() : " + i);
            }
            return volume;
        }
    }
}
