package algorithm.java.programmers.lv0;

import java.util.Arrays;

public class 머쓱이보다_키_큰사람 {

    public int solution(int[] array, int height) {
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] > height) return array.length -i;
        }
        return 0;
    }

    public int solution2(int[] array, int height) {
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] > height) return array.length -i;
        }
        return 0;
    }

}
