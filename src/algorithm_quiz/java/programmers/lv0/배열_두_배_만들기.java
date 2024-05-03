package algorithm_quiz.java.programmers.lv0;

import java.util.Arrays;

public class 배열_두_배_만들기 {

    public int[] solution(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            numbers[i] = n * 2;
        }
        return numbers;
    }

    static class OtherPeopleAnswer {
        public int[] solution(int[] numbers) {
            return Arrays.stream(numbers).map(i -> i * 2).toArray();
        }

        public int[] solution2(int[] numbers) {
            for(int i=0; i<numbers.length; i++) numbers[i] *=2;
            return numbers;
        }
    }
}
