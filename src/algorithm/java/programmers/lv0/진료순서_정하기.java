package algorithm.java.programmers.lv0;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static class OtherPeopleAnswer {
        /*
        테스트 1 〉	통과 (5.64ms, 74.3MB)
        테스트 2 〉	통과 (4.14ms, 73.4MB)
        테스트 3 〉	통과 (6.47ms, 72.1MB)
        테스트 4 〉	통과 (4.41ms, 76.6MB)
        테스트 5 〉	통과 (5.89ms, 78.9MB)
        테스트 6 〉	통과 (3.73ms, 71.2MB)
        테스트 7 〉	통과 (4.90ms, 73MB)
        테스트 8 〉	통과 (3.85ms, 75.1MB)
         */
        public int[] solution(int[] e) {
            return Arrays.stream(e).map(i -> Arrays.stream(e).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).indexOf(i) + 1).toArray();
        }

        /*
        테스트 1 〉	통과 (0.02ms, 74MB)
        테스트 2 〉	통과 (0.02ms, 73.7MB)
        테스트 3 〉	통과 (0.02ms, 75.7MB)
        테스트 4 〉	통과 (0.01ms, 72.9MB)
        테스트 5 〉	통과 (0.02ms, 80.5MB)
        테스트 6 〉	통과 (0.01ms, 77.3MB)
        테스트 7 〉	통과 (0.03ms, 76.5MB)
        테스트 8 〉	통과 (0.03ms, 73.6MB)
         */
        public int[] solution2(int[] emergency) {
            int[] answer = new int[emergency.length];

            for(int i = 0; i < answer.length; i++){
                if(answer[i] != 0){
                    continue;
                }
                int idx = 1;
                for(int j = 0; j < answer.length; j++){
                    if(emergency[i] < emergency[j]){
                        idx++;
                    }
                }
                answer[i] = idx;
            }
            return answer;
        }
    }
}
