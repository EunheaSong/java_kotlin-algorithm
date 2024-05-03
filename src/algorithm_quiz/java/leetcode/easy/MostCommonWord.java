package algorithm_quiz.java.leetcode.easy;

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

    public static class BookAnswer{
        public String mostCommonWord(String paragraph, String[] banned) {
            Set<String> ban = new HashSet<>(Arrays.asList(banned));
            Map<String, Integer> counts = new HashMap<>();

            String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

            for (String w : words) {
                if (!ban.contains(w)) {
                    /*
                    getOrDefault -> 첫번째 파라미터로 키 값을 주고,
                        해당 키값과 일치하는 게 없을 경우 두번째 파라미터로 준 기본 값을 리턴한다.
                     */
                    counts.put(w, counts.getOrDefault(w, 0) + 1);
                }
            }
            /*
            Collections.max() ->
            첫 번째 파라미터에는 컬렉션의 구현체를 받는다. (List, Set,
            (nullable) 두 번째 파라미터에는 Comparator (정렬 기준) 값을 받는다.
            첫 번쩨 파라미터만 있을 경우에는 해당 컬렉션의 오브젝트의 comparator 를 기준으로 max 값이 찾아지고,
            두 번째 파라미터로 기준을 주었을 때는 해당 comparator 를 기준으로 max 값이 찾아진다.
            ex )
            LinkedList<String> d = new LinkedList<>();
            String a = Collections.max(
                d,
                (s1, s2) -> {
                    char aa = s1.length() > 1 ? s1.charAt(0) : ' ';
                    char b = s2.length() > 1 ? s2.charAt(0) : ' ';
                    return Character.compare(aa, b);
                }
            );

            Map.Entry ->
             map 은 순회를 보장하지 않는다. (루프를 돌며 값을 조회한다던가 하는 행위를 할 수 없음.)
             이러한 이유로 map 에서는 Entry 인터페이스를 통해 entrySet() 등의 메서드를 지원하여 set 형태로 순회를 돌 수 있게 한다.
             또한 set 형태로 변경되었을 때 사용할 수 있는 여러가지 메서드를 지원한다.
            */
            return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
        }
    }
}
