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

    static class OtherPeopleAnswer {

        public int solution(int price) {
            int answer = 0;

            if(price>=500000) return (int)(price*0.8);
            if(price>=300000) return (int)(price*0.9);
            if(price>=100000) return (int)(price*0.95);

            return price;
        }

        public int solution2(int price) {
            int answer = 0;

            if(price>=100000 && price < 300000){
                answer = price * 95 / 100;
            }else if(price>=200000 && price < 500000){
                answer = price * 90 / 100;
            }else if(price>=500000){
                answer = price * 80 / 100;
            }else{
                answer = price;
            }
            return answer;
        }
    }
}
