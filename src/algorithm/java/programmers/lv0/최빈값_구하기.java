package algorithm.java.programmers.lv0;

import java.util.HashMap;
import java.util.Map;

public class 최빈값_구하기 {
    public int solution(int[] array) {
        int answer = 0;
        int key = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : array) {
            if (m.containsKey(i)) m.put(i, m.get(i) + 1);
            else m.put(i, 1);
            if (answer < m.get(i)) {
                answer = m.get(i);
                key = i;
            }
        }
        for (int j : array) {
            if (key != j && answer == m.get(j)) return -1;
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
