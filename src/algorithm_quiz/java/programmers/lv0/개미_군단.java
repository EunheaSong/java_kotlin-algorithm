package algorithm_quiz.java.programmers.lv0;

public class 개미_군단 {

    public int solution(int hp) {
        int answer = 0;
        if (5 <= hp) {
            answer += hp / 5;
            hp %= 5;
        }
        if (3 <= hp) {
            answer += hp / 3;
            hp %= 3;
        }
        answer += hp;
        return answer;
    }

    static class OtherPeopleAnswer {
        public int solution(int hp) {
            return hp / 5 + (hp % 5 / 3) + hp % 5 % 3;
        }
    }
}
