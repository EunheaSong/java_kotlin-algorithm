package algorithm.java.programmers.lv0;

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
}
