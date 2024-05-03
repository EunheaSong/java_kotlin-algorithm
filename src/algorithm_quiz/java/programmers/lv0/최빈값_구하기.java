package algorithm_quiz.java.programmers.lv0;

import java.util.HashMap;
import java.util.Map;

public class 최빈값_구하기 {
    public int solution(int[] array) {
        int max = 0;
        int key = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : array) {
            int count = m.getOrDefault(i, 0) + 1;
            m.put(i, count);
            if (max < count) {
                max = count;
                key = i;
            } else if (max == count) key = -1;
        }
        return key;
    }

    static class OtherPeopleAnswer {
        public int solution(int[] array) {
            int maxCount = 0;
            int answer = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for(int number : array){
                int count = map.getOrDefault(number, 0) + 1;
                if(count > maxCount){
                    maxCount = count;
                    answer = number;
                }
                else  if(count == maxCount){
                    answer = -1;
                }
                map.put(number, count);
            }
            return answer;
        }
    }
}
