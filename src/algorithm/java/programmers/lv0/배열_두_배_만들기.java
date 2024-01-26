package algorithm.java.programmers.lv0;

public class 배열_두_배_만들기 {

    public int[] solution(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            numbers[i] = n * 2;
        }
        return numbers;
    }
}
