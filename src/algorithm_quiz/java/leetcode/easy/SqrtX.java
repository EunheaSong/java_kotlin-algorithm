package algorithm_quiz.java.leetcode.easy;

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

    static class LeedCodeAnswer {
        public int mySqrt(int x) {
            if (x==0 || x==1){
                return x;
            }
            int start = 0;
            int end = x;
            while (start<=end){
                int mid = start + (end - start)/2;
                if((long)mid*mid>(long)x)
                    end = mid - 1;
                else if(mid * mid == x)
                    return mid;
                else
                    start = mid + 1;
            }
            return Math.round(end); //이것도 내장 함수이지 않나?
        }
    }

    //내장된 함수를 사용하지 말라고 했으므로 이 방식은 사용하면 안되는 것 같다. 그런데 많은 사람들이 이 대답을 제출한 것으로 보인다..
//    public int mySqrt(int x) {
//        return (int) Math.sqrt(x);
//    }
}
