package algorithm_quiz.java.programmers.lv0;

import java.util.stream.IntStream;

public class 순서쌍의_갯수 {

    public int solution(int n) {
        int answer = 0;
        int l = 1;
        while(l <= n) {
            if(n % l == 0) answer++;
            l++;
        }
        return answer;
    }

    static class OtherPeopleAnswer {
        public int solution(int n) {
            return (int) IntStream.rangeClosed(1, n).filter(i -> n % i == 0).count();
        }
    }
}
