package algorithm.java.programmers.lv0;

public class 문자_반복_출력하기 {

    public String solution(String my_string, int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            //String.valueOf() 하지말고, 그냥 문자열을 하나 붙이는 것이 더 간단하겠다.
            //ex -> c + "" (이런 식으로...)
            answer.append(String.valueOf(c).repeat(n));
        }
        return answer.toString();
    }
}
