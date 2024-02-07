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

    public static class OtherPeopleAnswer {
        public int[] solution(int num, int total) {
            int[] answer = new int[num];
            int check = num*(num+1) / 2;
            int start = (total - check) / num + 1;
            for (int i = 0; i < answer.length; i++) {
                answer[i] = start + i ;
            }
            return answer;
        }

        public int[] solution2(int num, int total) {
            int[] answer = new int[num];
            int mid = total / num;
            int m = (num - 1) / 2;
            for(int i = 0; i < num; i++) {
                answer[i] = mid + i - m;
            }
            return answer;
        }

        public int[] solution3(int num, int total) {
            int[] answer = new int[num];
            int temp = 0;
            for(int i=0;i<num;i++){
                temp+=i;
            }
            int value = (total-temp)/num;

            for (int i=0;i<num;i++) {
                answer[i]=i+value;
            }

            return answer;
        }
    }
}
