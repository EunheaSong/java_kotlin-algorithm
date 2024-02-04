package algorithm.java.programmers.lv0;

public class 외계행성의_나이 {
    public String solution(int age) {
        StringBuilder answer = new StringBuilder();
        String a = Integer.toString(age);
        for (int i = 0; i < a.length(); i++) {
            answer.append((char)(49 + (int)a.charAt(i)));
        }
        return answer.toString();
    }
}