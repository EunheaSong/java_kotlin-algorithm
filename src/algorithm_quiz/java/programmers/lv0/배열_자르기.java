package algorithm_quiz.java.programmers.lv0;

import java.util.Arrays;
import java.util.stream.IntStream;

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

    static class OtherPeopleAnswer {

        public int[] solution(int[] numbers, int num1, int num2) {
            int[] answer = new int[num2 - num1 + 1];
            for (int i = num1; i <= num2; i++) {
                answer[i -num1] = numbers[i];
            }
            return answer;
        }

        // 굳이 stream 을 사용할 필요가 있나싶다. 간단히 구현가능하기 때문에 stream 을 사용하면 오히려 성능이 저하되는 느낌.
        public int[] solution2(int[] numbers, int num1, int num2) {
            return IntStream.rangeClosed(num1, num2).map(i -> numbers[i]).toArray();
        }

        // 굳이 stream 을 사용할 필요가 있나싶다. 간단히 구현가능하기 때문에 stream 을 사용하면 오히려 성능이 저하되는 느낌.
        public int[] solution3(int[] numbers, int num1, int num2) {
            int[] answer = Arrays.stream(numbers, num1, num2+1).toArray();
            return answer;
        }
    }

}
