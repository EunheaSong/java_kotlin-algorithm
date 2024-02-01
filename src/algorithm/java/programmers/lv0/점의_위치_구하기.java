package algorithm.java.programmers.lv0;

public class 점의_위치_구하기 {
    public int solution(int[] dot) {
        int x = dot[0];
        int y = dot[1];
        if (x > 0 && y > 0) return 1;
        if (x < 0 && y > 0) return 2;
        if (x < 0 && y < 0) return 3;
        if (x > 0 && y < 0) return 4;
        return 0;
    }

    static class OtherPeopleAnswer {

        public int solution(int[] dot) {
            int xParam = dot[0] < 0 ? 1 : 0;
            int yParam = dot[1] < 0 ? 2 : 0;

            return 1 + ((xParam | yParam) ^ (yParam >> 1));
        }

        public int solution2(int[] dot) {
            int answer = 0;
            if(dot[0] > 0)
                if(dot[1] > 0) answer = 1;
                else answer = 4;
            else
            if(dot[1] > 0) answer = 2;
            else answer = 3;

            return answer;
        }
    }
}
