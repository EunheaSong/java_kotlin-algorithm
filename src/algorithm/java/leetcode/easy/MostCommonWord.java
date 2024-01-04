package algorithm.java.leetcode.easy;

import java.util.*;

public class MostCommonWord {
    /*
        System.out.println("819. Most Common Word : ");
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String[] banned = {"hit"};
//        String paragraph = "Bob. hIt, baLl";
//        String[] banned = {"bob", "hit"};
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};
        MostCommonWord mcw = new MostCommonWord();
        System.out.println(mcw.mostCommonWord(paragraph, banned));

        Example 1:
        Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
        Output: "ball"
        Explanation:
        "hit" occurs 3 times, but it is a banned word.
        "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
        Note that words in the paragraph are not case sensitive,
        that punctuation is ignored (even if adjacent to words, such as "ball,"),
        and that "hit" isn't the answer even though it occurs more because it is banned.

        Example 2:
        Input: paragraph = "a.", banned = []
        Output: "a"
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        String s = paragraph.replaceAll("[^a-zA-Z0-9\\s]", " ").toLowerCase();
        String[] ss = s.split("\\s+");
        List<String> b = Arrays.asList(banned);
        int max = 0;
        String word = "";
        for (String str : ss) {
            if (b.contains(str)) {
                continue;
            }
            int count = 0;
            for (String value : ss) {
                if (str.equals(value)) {
                    count++;
                }
            }
            if (max < count){
                max = count;
                word = str;
            }
        }
        return word;
    }

}
