package algorithm_quiz.java.leetcode.medium;

import java.util.*;

public class GroupAnagrams {
    /*
        System.out.println("49. Group Anagrams : ");
//        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs = {"ddddddddddg","dgggggggggg"};
        GroupAnagrams ga = new GroupAnagrams();
        List<List<String>> list = ga.groupAnagrams2(strs);
        for (List<String> strings : list) {
            System.out.print("[");
            for (String s: strings) {
                System.out.print(s + ",");
            }
            System.out.println("]");
        }

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

    public static class BookAnswer {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> results = new HashMap<>();
            for (String s: strs) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String key = String.valueOf(chars);
                if (!results.containsKey(key)) {
                    results.put(key, new ArrayList<>());
                }
                results.get(key).add(s);
            }
            return new ArrayList<>(results.values());
        }
    }

}
