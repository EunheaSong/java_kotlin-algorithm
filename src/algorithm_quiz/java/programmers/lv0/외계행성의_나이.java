package algorithm_quiz.java.programmers.lv0;

import java.util.stream.Collectors;

public class 외계행성의_나이 {
    public String solution(int age) {
        StringBuilder answer = new StringBuilder();
        String a = Integer.toString(age);
        for (int i = 0; i < a.length(); i++) {
            answer.append((char)(49 + (int)a.charAt(i)));
        }
        return answer.toString();
    }

    static class OtherPeopleAnswer {
        public String solution(int age) {
            return String.valueOf(age).chars().mapToObj(operand -> String.valueOf((char) (49 + operand))).collect(Collectors.joining());
        }
        /*
        위 코드처럼 stream 을 사용하여 한 줄로 작성할 수도 있지만, 개인적으로는 아래의 코드가 가독성이 더 좋아보이고 더 깔끔해보인다.
         */
        public String solution2(int age) {
            StringBuilder sb = new StringBuilder();
            while(age > 0) {
                sb.insert(0, (char) ((age % 10) + (int)'a'));
                age /= 10;
            }
            return sb.toString();
        }
    }
}