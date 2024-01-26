package algorithm.java.programmers.lv0;

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

}
