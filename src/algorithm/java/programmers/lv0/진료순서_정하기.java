package algorithm.java.programmers.lv0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 진료순서_정하기 {

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
