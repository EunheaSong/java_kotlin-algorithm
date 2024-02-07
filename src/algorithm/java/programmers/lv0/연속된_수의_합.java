package algorithm.java.programmers.lv0;

public class 연속된_수의_합 {

    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int a = total;
        if (total == 0) {
            int q = -num / 2;
            for (int i = 0; i < num; i++) {
                answer[i] = q + i;
            }
        } else {
            while (total > 0) {
                int b = 0;
                for (int i = 0; i < num; i++) {
                    b += (a - i);
                }
                if (total == b) {
                    for (int i = 0; i < num; i++){
                        answer[(num-1)-i] = (a - i);
                    }
                    break;
                } else {
                    a--;
                }
            }
        }
        return answer;
    }
}
