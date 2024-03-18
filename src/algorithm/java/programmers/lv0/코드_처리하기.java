package algorithm.java.programmers.lv0;

public class 코드_처리하기 {
    public String solution(String code) {
        StringBuilder ret = new StringBuilder();
        int mode = 0;
        for (int i = 0; i < code.length(); i++) {
            if (mode == 1 && code.charAt(i) == '1') {
                mode = 0;
            } else if (mode == 1 && i % 2 != 0) {
                ret.append(code.charAt(i));
            } else if (mode != 1 && code.charAt(i) == '1') {
                mode = 1;
            } else if (mode != 1 && i % 2 == 0) {
                ret.append(code.charAt(i));
            }
        }
        return (ret.toString().isEmpty()) ? "EMPTY" : ret.toString();
    }

    public String solution_타인의_답(String code) {
        StringBuilder answer = new StringBuilder();
        int mode = 0;
        for (int i = 0; i < code.length(); i++) {
            char current = code.charAt(i);
            if (current == '1') {
                mode = mode == 0 ? 1 : 0;
                continue;
            }
            if (i % 2 == mode) {
                answer.append(current);
            }
        }
        return answer.length() == 0 ? "EMPTY" : answer.toString();
    }
}
