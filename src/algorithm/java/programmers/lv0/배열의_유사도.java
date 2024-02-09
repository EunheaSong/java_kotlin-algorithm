package algorithm.java.programmers.lv0;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 배열의_유사도 {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for (String s : s1) {
            for (String ss : s2) {
                if (s.equals(ss)) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    public static class OtherPeopleAnswer {
        public int solution(String[] s1, String[] s2) {
            Set<String> set = new HashSet<>(Arrays.asList(s1));
            return (int)Arrays.stream(s2).filter(set::contains).count();
        }
    }
}
