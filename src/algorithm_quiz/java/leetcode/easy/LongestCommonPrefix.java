package algorithm_quiz.java.leetcode.easy;

import java.util.Arrays;

public class LongestCommonPrefix {
    /*
    String[] strs = {"a"};
    String[] strs = {"flower","flower", "flower", "flower"};
    ArrayPartition ap = new ArrayPartition();
    System.out.println(ap.arrayPairSum(nums));

    14. Longest Common Prefix
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".

    Example 1:
    Input: strs = ["flower","flow","flight"]
    Output: "fl"

    Example 2:
    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.

    Constraints:
    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.
     */

    public String longestCommonPrefix(String[] strs) { //1ms , 41.51mb
        StringBuilder answer = new StringBuilder();
        boolean equals = true;
        int miniumLen = strs[0].length();
        for(String s : strs) {
            miniumLen = Math.min(miniumLen, s.length());
        }
        for(int i = 0; i < miniumLen; i++) {
            char c = strs[0].charAt(i);
            if(strs.length > 1 && equals) {
                for(int j = 0; j < strs.length-1; j++) {
                    if (c != strs[j+1].charAt(i)) {
                        equals = false;
                        break;
                    }
                }
            }
            if(equals) answer.append(c);
        }
        return answer.toString();
    }

    public static class LeetcodeOtherAnswer {

        //Fastest answer. runtime : 0ms
        public String longestCommonPrefix(String[] strs) {
            String str;
            int end = 0;
            char curr;
            int shortestLen = 201;
            int len = 0;
            for (int i = 0; i < strs.length; i++) {
                len = strs[i].length();
                if (shortestLen > len) {
                    shortestLen = len;
                }
            }
            // System.out.println("shortestLen = " + shortestLen);
            boolean differs = false;
            for (int j = 0; j < shortestLen; j++) {
                curr = strs[0].charAt(j);
                for (int i = 0; i < strs.length; i++) {
                    if (strs[i].charAt(j) != curr) {
                        differs = true;
                        break;
                    }
                }
                if (!differs) {
                    end++;
                } else {
                    break;
                }
            }
            // System.out.println("end = " + end);
            return strs[0].substring(0, end);
        }

        // most efficient use of memory. Memory : 38.1 mb
        public String longestCommonPrefix2(String[] strs) {
            if (strs.length == 0)
                return "";

            for (int i = 0; i < strs[0].length(); ++i)
                for (int j = 1; j < strs.length; ++j)
                    if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i))
                        return strs[0].substring(0, i);

            return strs[0];
        }
    }
}
