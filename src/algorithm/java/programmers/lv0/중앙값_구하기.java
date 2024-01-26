package algorithm.java.programmers.lv0;

import java.util.Arrays;

public class 중앙값_구하기 {
    public int solution(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }

    static class OtherPeopleAnswer {
        public int solution(int[] array) {
            int answer = 0;

            //java util 을 사용하지 않는다면 이렇게 반복문을 통한 정렬을 해주어야할 것이다.
            for (int i = 0; i < array.length; i++) {
                for (int j = i; j < array.length; j++) {
                    if (array[j] < array[i]) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }

            answer = array[array.length / 2];

            return answer;
        }
    }
}
