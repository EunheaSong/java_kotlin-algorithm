package algorithm.java.programmers.lv0;

import java.util.Arrays;

public class 배열_자르기 {

    public int[] solution(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2+1);
    }

    public int[] solution2(int[] numbers, int num1, int num2) {
        int[] answer = new int[1 + num2 - num1];
        int j = 0;
        for (int i = num1; i <= num2; i++) {
            answer[j] = numbers[i];
            j++;
        }
        return answer;
    }

}
