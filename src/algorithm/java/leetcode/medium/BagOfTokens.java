package algorithm.java.leetcode.medium;

import java.util.Arrays;

public class BagOfTokens {
    /*
    948. Bag of Tokens
     */
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0, j = (tokens.length - 1);
        int score = 0;
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i++];
                // 후위 연산이기 때문에 power 에 - 되는 값은 현재 i의 값이고, 다음 단계로 이동하며 i가 증가한다.
                score++;
            } else if (score > 0 && i < j) {
                power += tokens[j--];
                score--;
            } else {
                return score;
            }
        }
        return score;
    }
}
