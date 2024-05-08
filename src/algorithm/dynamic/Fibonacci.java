package algorithm.dynamic;

public class Fibonacci {

    static int count = 0;

    public static int fib_no_memo(int n) {
        count++;
        if (n == 0 || n == 1) return n;
        return fib_no_memo(n -1) + fib_no_memo(n - 2);
    }

    static Integer[] memo = new Integer[100];

    public static int fib_with_memo(int n) {
        count++;
        if (memo[n] != null) return memo[n];
        if (n == 0 || n == 1) return n;
        memo[n] = fib_with_memo(n - 1) + fib_with_memo(n - 2);
        return memo[n];
    }

    public static int fib_bottom_up(int n) {
        int[] fibList = new int[n + 1];
        fibList[0] = 0;
        fibList[1] = 1;

        for (int index = 2; index <= n; index++) {
            count++;
            fibList[index] = fibList[index - 1] + fibList[index - 2];
        }
        return fibList[n];
    }


    public static void main(String[] args) {
        int n = 10;
        System.out.println("n의 피보나치 수열 : " + fib_no_memo(n));
        System.out.println("fib의 호출 횟수 : " + count);

        count = 0;
        System.out.println("\nn의 피보나치 수열 : " + fib_with_memo(n));
        System.out.println("fib의 호출 횟수 : " + count);

        count = 0;
        System.out.println("\nn의 피보나치 수열 : " + fib_bottom_up(n));
        System.out.println("fib의 호출 횟수 : " + count);
    }
}
