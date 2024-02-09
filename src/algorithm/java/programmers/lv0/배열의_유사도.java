package algorithm.java.programmers.lv0;

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
}
