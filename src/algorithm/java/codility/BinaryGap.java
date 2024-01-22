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

    /*
    두 번째 시도 : 86%
    https://app.codility.com/demo/results/training3UXFWK-EA6/
    int N = 51712;
    int N = 20;
    int N = 6;
    int N = 328;
     */
    public int solution2(int N) {
        String str = Integer.toBinaryString(N);
        System.out.println(str);
        int answer = 0;
        int a = 0;
        if (str.replace("0", "").equals("1")) return answer;
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == '1') {
                a = 0;
                continue;
            }
            a++;
            answer = Math.max(a, answer);
        }
        return answer;
    }

}
