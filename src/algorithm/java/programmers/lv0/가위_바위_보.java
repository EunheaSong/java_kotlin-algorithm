package algorithm.java.programmers.lv0;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 가위_바위_보 {
    public String solution(String rsp) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < rsp.length(); i++) {
            switch(rsp.charAt(i)) {
                case '0' : answer.append("5"); break;
                case '2' : answer.append("0"); break;
                case '5' : answer.append("2"); break;
            }
        }
        return answer.toString();
    }

    public static class OtherPeopleAnswer {
        public String solution(String rsp) {
            return Arrays.stream(rsp.split("")).map(s -> s.equals("2") ? "0" : s.equals("0") ? "5" : "2").collect(Collectors.joining());
        }
    }
}
