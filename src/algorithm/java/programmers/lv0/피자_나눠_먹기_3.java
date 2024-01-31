package algorithm.java.programmers.lv0;

public class 피자_나눠_먹기_3 {

    public int solution(int slice, int n) {
        int answer = 1;
        int s = slice;
        while (slice < n) {
            answer++;
            slice += s;
        }
        return answer;
    }
}
