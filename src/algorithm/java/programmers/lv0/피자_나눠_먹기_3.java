package algorithm.java.programmers.lv0;

public class 피자_나눠_먹기_3 {

    public int solution(int slice, int n) {
        int answer = 1;
        int s = slice;
        while (slice < n) {
            answer++;
            slice += s;
        }
        return answer;
    }

    static class OtherPeopleAnswer {

        public int solution(int slice, int n) {
            return n % slice > 0 ? n/slice+1 : n/slice;
        }

        public int solution2(int slice, int n) {
            int answer = 0;
            if(n%slice == 0)
            {
                answer = n/slice;
            }
            else {
                answer = n/slice + 1;
            }

            return answer;
        }
    }
}
