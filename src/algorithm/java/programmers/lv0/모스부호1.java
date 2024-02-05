package algorithm.java.programmers.lv0;

import java.util.List;

public class 모스부호1 {
    public String solution(String letter) {
        StringBuilder answer = new StringBuilder();
        List<String> morseArray = List.of(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..");
        String[] l = letter.split(" ");
        for (String s: l) {
            answer.append((char)('a' + morseArray.indexOf(s)));
        }

        return answer.toString();
    }
}
