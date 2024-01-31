package algorithm.java.programmers.lv0;

public class 옷가게_할인_받기 {

    public int solution(int price) {
        int answer = price;
        if (500000 <= price) {
            answer = (int)((double) price * 0.80);
        } else if (300000 <= price) {
            answer = (int)((double) price * 0.90);
        } else if (100000 <= price) {
            answer = (int)((double) price * 0.95);
        }
        return answer;
    }
}
