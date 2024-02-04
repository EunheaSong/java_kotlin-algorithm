package algorithm.java.programmers.lv0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 진료순서_정하기 {

    /*
    테스트 1 〉	통과 (0.41ms, 70.3MB)
    테스트 2 〉	통과 (0.36ms, 65.3MB)
    테스트 3 〉	통과 (0.47ms, 75MB)
    테스트 4 〉	통과 (0.40ms, 73.9MB)
    테스트 5 〉	통과 (0.56ms, 78.4MB)
    테스트 6 〉	통과 (0.39ms, 76.7MB)
    테스트 7 〉	통과 (0.46ms, 77.4MB)
    테스트 8 〉	통과 (0.51ms, 72.8MB)
     */
    public int[] solution(int[] emergency) {
        int[] answer = emergency.clone();
        Map<Integer, Integer> m = new HashMap<>();
        Arrays.sort(emergency);
        for (int i = 0; i < emergency.length; i++) {
            m.put(emergency[i], emergency.length - i);
        }
        for (int i = 0; i < answer.length; i++) {
            int j = m.get(answer[i]);
            answer[i] = j;
        }
        return answer;
    }
}
