package algorithm.java.programmers.lv0;

import java.util.Arrays;

public class 머쓱이보다_키_큰사람 {

    /*
    테스트 1 〉	통과 (0.33ms, 66.2MB)
    테스트 2 〉	통과 (0.38ms, 72.1MB)
    테스트 3 〉	통과 (0.48ms, 78.8MB)
    테스트 4 〉	통과 (0.32ms, 76.8MB)
    */
    public int solution(int[] array, int height) {
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] > height) return array.length -i;
        }
        return 0;
    }

    /*
    테스트 1 〉	통과 (1.74ms, 76.3MB)
    테스트 2 〉	통과 (2.16ms, 84.1MB)
    테스트 3 〉	통과 (1.62ms, 73.3MB)
    테스트 4 〉	통과 (1.64ms, 75.3MB)
    */
    public int solution2(int[] array, int height) {
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] > height) return array.length -i;
        }
        return 0;
    }

    //stream 을 사용할 수도 있지만, 연산 내용이 간단하기 때문에 for loop와 속도가 많이 차이난다.
    //기본자료형을 사용하는 경우 연산이 간단할 때는 기본적인 반복문을 수행하고, 복잡한 연산의 경우 stream을 사용하는 것이 좋을 것 같다.

}
