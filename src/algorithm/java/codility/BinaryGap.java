package algorithm.java.codility;

public class BinaryGap {
    /*
    첫 시도 : 40%
    https://app.codility.com/demo/results/training6DGPCW-WCP/
     */
    public int solution(int N) {
        String[] str = Integer.toBinaryString(N).split("1");
        System.out.println(str.length);
        System.out.println(Integer.toBinaryString(N));
        int answer = 0;
        if (str.length > 2) {
            for (String s : str) {
                int i = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '0') {
                        i++;
                    }
                }
                answer = Math.max(answer, i);
            }
        }
        return answer;
    }
}
