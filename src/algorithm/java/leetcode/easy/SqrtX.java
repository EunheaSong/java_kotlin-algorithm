package algorithm.java.leetcode.easy;

public class SqrtX {
    /*
    69. Sqrt(x)
    Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
    The returned integer should be non-negative as well.
    You must not use any built-in exponent function or operator.
    For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
     */
    public int mySqrt(int x) {
        if (x == 0) return x;
        int root = 0;
        int end = x / 2;
        while (root <= end) {
            root++;
            end = x / root;
        }
        if (root * root > x || root * root < 0) return --root;
        return root;
    }

}
