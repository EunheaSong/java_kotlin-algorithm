package algorithm.java.programmers.lv0;

public class 더_크게_합치기 {
    public int solution(int a, int b) {
        String s1 = "" + a + b;
        String s2 = "" + b + a;
        if (s1.compareTo(s2) > 0 ) {
            return Integer.parseInt(s1);
        } else {
            return Integer.parseInt(s2);
        }
    }

    public class 두_수의_연산값으로_합치기 {
        public int solution(int a, int b) {
            int i1= Integer.parseInt("" + a + b);
            int i2 = 2 * a * b;
            return Math.max(i1, i2);
        }
    }
}