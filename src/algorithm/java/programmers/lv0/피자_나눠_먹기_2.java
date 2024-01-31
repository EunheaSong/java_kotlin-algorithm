package algorithm.java.programmers.lv0;

public class 피자_나눠_먹기_2 {

    public int solution(int n) {
        int answer = 1;
        int pizza = 6;
        while (pizza % n > 0) {
            pizza += 6;
            answer++;
        }
        return answer;
    }
}
