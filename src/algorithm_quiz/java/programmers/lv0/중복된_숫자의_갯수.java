package algorithm_quiz.java.programmers.lv0;

import java.util.Arrays;

public class 중복된_숫자의_갯수 {

    public int solution(int[] array, int n) {
        int answer = 0;
        for (int i: array) {
            if (i == n) answer++;
        }
        return answer;
    }

    public int solution2(int[] array, int n) {
        return (int) Arrays.stream(array).filter(i -> i == n).count();
    }

}
