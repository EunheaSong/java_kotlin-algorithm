package algorithm_quiz.java.programmers.lv0;

import java.util.Arrays;

public class 배열_원소의_길이 {

    /*
    테스트 1 〉	통과 (0.01ms, 76.5MB)
    테스트 2 〉	통과 (0.03ms, 78.3MB)
    테스트 3 〉	통과 (0.02ms, 73.7MB)
    테스트 4 〉	통과 (0.02ms, 73.2MB)
    테스트 5 〉	통과 (0.02ms, 74MB)
    테스트 6 〉	통과 (0.02ms, 65.3MB)
    */
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        int i = 0;
        for (String s : strlist) {
            answer[i] = s.length();
            i++;
        }
        return answer;
    }

    /*
    테스트 1 〉	통과 (1.81ms, 75.4MB)
    테스트 2 〉	통과 (2.30ms, 73.5MB)
    테스트 3 〉	통과 (3.24ms, 75.6MB)
    테스트 4 〉	통과 (2.35ms, 71.3MB)
    테스트 5 〉	통과 (2.69ms, 76.8MB)
    테스트 6 〉	통과 (1.83ms, 70.3MB)
    */
    public int[] solution2(String[] strlist) {
        return Arrays.stream(strlist).mapToInt(s -> s.length()).toArray();
    }

    static class OtherPeopleAnswer{
        public int[] solution(String[] strList) {
            return Arrays.stream(strList).mapToInt(String::length).toArray();
        }
    }
}
