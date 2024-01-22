package algorithm.java.codility;

public class CyclicRotation {
    /*
    첫 시도 : 87%
    https://app.codility.com/demo/results/training2F4QCQ-K4R/
     */
    public int[] solution(int[] A, int K) {
        // Implement your solution here
        for (int j = 0; j < K; j++){
            int num = A[A.length-1];
            for (int i = A.length - 1; i > 0; i--) {
                int n = A[i-1];
                A[i] = n;
            }
            A[0] = num;
        }
        return A;
    }
}
