package algorithm.java.leetcode.easy;

public class PowerOfTwo {
    /*
    231. Power of Two
     */

    /*
    2 의 제곱은 & 연산을 했을 때 모두 1이 된다. (1000 이 된다.)
    -> & 연산 : 이진수 AND 연산.
        두 개의 이진수를 가지고 비트 단위의 AND 연산을 수행한다.
         두 비트 모두 다 1일 경우에만 결과가 1이 된다.
         8 & 8 : 1000 & 1000 -> 1000
         16 & 16 : 10000 & 10000 -> 10000
     */
    public boolean isPowerOfTwo(int n) {
//        System.out.println(Integer.toBinaryString(n));
        return n > 0 && (n & n - 1) == 0;
    }

    //재귀를 사용한 방법.
    public boolean isPowerOfTwo2(int n) {
        if (n == 1) return true;
        else if (n == 0) return false;
        else if (n % 2 != 0) return false;
        return isPowerOfTwo2(n / 2);
    }
}
