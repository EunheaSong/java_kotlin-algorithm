package algorithm.java.programmers.lv0;

import java.util.Arrays;

public class 뒤에서_5등_위로 {
    /*
        테스트 1 〉	통과 (0.46ms, 80.9MB)
        테스트 2 〉	통과 (0.36ms, 86.1MB)
        테스트 3 〉	통과 (0.36ms, 72.3MB)
        테스트 4 〉	통과 (0.52ms, 84.7MB)
        테스트 5 〉	통과 (0.36ms, 76.7MB)
     */
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        return Arrays.copyOfRange(num_list,4, num_list.length-1);
    }

    /*
    stream 사용시 속도가 위의 답보다 훨씬 오래 걸린다.
    테스트 1 〉	통과 (5.96ms, 74.3MB)
    테스트 2 〉	통과 (6.02ms, 76.6MB)
    테스트 3 〉	통과 (3.67ms, 75.7MB)
    테스트 4 〉	통과 (2.37ms, 67.3MB)
    테스트 5 〉	통과 (8.63ms, 78.2MB)
     */
    public int[] solution2(int[] num_list) {
        return Arrays.stream(num_list).sorted().skip(5).toArray();
    }
}
