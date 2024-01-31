package algorithm.java.programmers.lv0;

import java.util.Arrays;

public class 배열_원소의_길이 {

    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        int i = 0;
        for (String s : strlist) {
            answer[i] = s.length();
            i++;
        }
        return answer;
    }

}
