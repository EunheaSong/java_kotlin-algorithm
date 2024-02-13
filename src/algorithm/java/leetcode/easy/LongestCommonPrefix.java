package algorithm.java.leetcode.easy;

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

    public String longestCommonPrefix(String[] strs) {
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
}
