package algorithm_quiz.java.programmers.lv0;

import java.util.stream.IntStream;

public class 짝수는_싫어요 {
    public int[] solution(int n) {
        int[] answer = new int[n % 2 == 0 ? n / 2 : n / 2 + 1];
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                answer[j] = i;
                j++;
            }
        }
        return answer;
    }

    static class OtherPeopleAnswer {
        /*
        스트림을 사용하여 코드가 간결해졌지만, 실행 결과를 보면 내가 작성한 답안과 10배 이상의 차이가 난다.
        나의 답안 결과 : 스트림 답안 결과
        테스트 1 〉	통과 (0.02ms, 74.4MB) : (4.78ms, 80MB)
        테스트 2 〉	통과 (0.02ms, 72.6MB) : (3.55ms, 71.2MB)
        테스트 3 〉	통과 (0.01ms, 78.9MB) : (2.92ms, 73.6MB)
        테스트 4 〉	통과 (0.02ms, 73.9MB) : (3.69ms, 77.9MB)
        테스트 5 〉	통과 (0.02ms, 80MB) : (3.75ms, 80.1MB)
        테스트 6 〉	통과 (0.03ms, 74.8MB) : (2.07ms, 77MB)
        테스트 7 〉	통과 (0.02ms, 77.4MB) : (2.21ms, 76.8MB)
        테스트 8 〉	통과 (0.02ms, 78.6MB) : (2.02ms, 75.3MB)
         */
        public int[] solution(int n) {
            return IntStream.rangeClosed(0, n).filter(value -> value % 2 == 1).toArray();
        }
    }
}
