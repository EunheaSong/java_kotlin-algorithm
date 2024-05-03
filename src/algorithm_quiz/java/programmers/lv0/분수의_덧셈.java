package algorithm_quiz.java.programmers.lv0;

public class 분수의_덧셈 {

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int a = 0;
        int newNumer = 0;
        int newDenom = 0;
        newDenom = denom1 * denom2;
        newNumer = (numer1 * denom2) + (numer2 * denom1);

        a = gcd(newNumer, newDenom);
        answer[0] = newNumer / a;
        answer[1] = newDenom / a;

        return answer;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static class OtherPeopleAnswer {
        public int[] solution(int denum1, int num1, int denum2, int num2) {
            int mother = num1 * num2;
            int son1 = num1 * denum2;
            int son2 = num2 * denum1;
            int totalSon = son1 + son2;
            for(int i = mother; i >= 1; i--){
                if(totalSon % i == 0 && mother % i == 0){
                    totalSon /= i;
                    mother /= i;
                }
            }
            int[] answer = {totalSon, mother};
            return answer;
        }
    }
}
