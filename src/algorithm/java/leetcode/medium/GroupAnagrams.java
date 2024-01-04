package algorithm.java.leetcode.medium;

import java.util.*;

public class GroupAnagrams {
    /*
        System.out.println("49. Group Anagrams : ");

        Example 1:
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        Example 2:
        Input: strs = [""]
        Output: [[""]]

        Example 3:
        Input: strs = ["a"]
        Output: [["a"]]
     */

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        for (String str: strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String s = String.valueOf(c);
            if (!group.containsKey(s)) {
                group.put(s, new ArrayList<>());
            }
            group.get(s).add(str);
        }
        return new ArrayList<>(group.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Word, List<String>> group = new HashMap<>();
        List<List<String>> words = new ArrayList<>();
        for (String str: strs) {
            System.out.println("==================");
            System.out.println("str : " + str);
            System.out.println(group.containsKey(new Word(str)));
            if (group.containsKey(new Word(str))) {
                continue;
            }
            List<String> l = new ArrayList<>();

            for (int i = 0; i < strs.length; i++) {
                String s = strs[i];
                if (str.length() != s.length()) continue;
                char[] chars = s.toCharArray();
                if (test(str, chars)) {
                    l.add(s);
                    System.out.println("add ing : " + s);
                }
            }
            group.put(new Word(str), l);
        }

        group.forEach((key, value) -> {
            words.add(value);
        });
        return words;

    }

    public class Word {
        String str;

        public Word(String str) {
            this.str = str;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Word s = (Word) obj;
            char[] chars = s.str.toCharArray();
            return test(this.str, chars);
        }

        @Override
        public int hashCode() {
            char[] chars = str.toCharArray();
            int hashCode = 0;
            for (char c : chars) {
                hashCode += (int) c;
            }
            return hashCode;
        }
    }

    public boolean test(String str, char[] chars) {
        for (char c : chars) {
            if (!str.contains(Character.toString(c))) {
                return false;
            }
        }
        return true;
    }


}
