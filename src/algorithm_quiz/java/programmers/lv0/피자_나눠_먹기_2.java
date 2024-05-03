package algorithm_quiz.java.programmers.lv0;

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

    static class OtherPeopleAnswer {

        public int GCD(int num1, int num2) {
            if (num1 % num2 == 0)
                return num2;
            return GCD(num2, num1 % num2);
        }

        public int LCM(int num1, int num2) {
            return num1 * num2 / GCD(num1, num2);
        }

        public int solution(int n) {
            return LCM(n, 6) / 6;
        }


        public int solution2(int n) {
            int answer = 1;
            while (true) {
                if(6*answer%n==0) break;
                answer++;
            }
            return answer;
        }

    }
}
