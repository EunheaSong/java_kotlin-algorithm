package algorithm.java.leetcode.medium;

import java.util.*;

public class ReorderDataInLogFiles {
    /*
        System.out.println("937번 Reorder Data in Log Files : ");
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
//        String[] logs = {"j je", "b fjt", "7 zbr", "m le", "o 33"};
//        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        ReorderDataInLogFiles r = new ReorderDataInLogFiles();
        String[] answer = r.reorderLogFiles(logs);
        for (String s : answer) {
            System.out.println(s);
        }
     */
    /*
    규칙 1. 문자로그가 숫자로그보다 앞에 온다.
    규칙 2. 문자로그는 내용의 알파벳 순으로 정렬한다.
    규칙 3. 숫자로그는
    문자 로그는 모든 숫자 로그 앞에 옵니다.
    편지 기록은 내용에 따라 사전순으로 정렬됩니다. 내용이 동일하면 식별자를 기준으로 사전순으로 정렬합니다.
    숫자 로그는 상대적 순서를 유지합니다.
    로그의 최종 순서를 반환합니다.
    Example 1:
    Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
    Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
    Explanation:
    The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
    The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".

    Example 2:
    Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
    Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]

    Constraints:
    1 <= logs.length <= 100
    3 <= logs[i].length <= 100
    All the tokens of logs[i] are separated by a single space.
    logs[i] is guaranteed to have an identifier and at least one word after the identifier.
     */
    public String[] reorderLogFiles(String[] logs) {
        List<String> a = new LinkedList<>();
        List<String> b = new ArrayList<String>();
        System.out.println("Start!");
        for (int i = 0; i < logs.length; i++) {
            String log = logs[i];
            String[] l = log.split(" ");
            char[] c = l[1].toCharArray();
            if (Character.isDigit(c[0])) {
                b.add(log);
                continue;
            }
            if (a.isEmpty()) {
                a.add(log);
            }
            for (int j = 0; j < a.size(); j++) {
                if (log.equals(a.get(j))) {
                    continue;
                }
                String[] l2 = a.get(j).split(" ");
                int t = test(l, l2);
                if (t > 0) {
                    // l 이 l2 보다 클 경우.
                    int x = t;
                    int y = 1;
                    while (x > 0) {
                        if (j + y == a.size()) {
                            a.add(j + y, log);
                            break;
                        }
                        x = test(l, a.get(j + y).split(" "));
                        if (x <= 0) {
                            a.add(j + y, log);
                        }
                        y++;
                    }
                    break;
                } else if (t < 0) {
                    // l 이 l2 보다 작거나 같을 경우.
                    a.add(j, log);
                    break;
                } else {
                    // 로그 내용이 다 같을 경우. 식별자로 구분.
                    int q = l[0].compareTo(l2[0]);
                    if (q > 0) {
                        a.add(j + 1, log);
                    } else {
                        a.add(j, log);
                    }
                    break;
                }
            }
        }
        a.addAll(b);
        return a.toArray(new String[a.size()]);
    }

    public int test(String[] x, String[] y) {
        for (int i = 1; i < x.length; i++) {
            int a = x[i].compareTo(y[i]);
            if (a > 0) {
                return 1;
            } else if (a < 0) {
                // l 이 l2 보다 작을 경우.
                return -1;
            }
        }
        /*
         return (x < y) ? -1 : ((x == y) ? 0 : 1);
         */
        return Integer.compare(x.length, y.length);
    }

    public static class BookAnswer{
        public String[] reorderLogFiles(String[] logs) {
            List<String> letterList = new ArrayList<>();
            List<String> digitList = new ArrayList<>();

            for (String log : logs) {
                if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                    digitList.add(log);
                } else {
                    letterList.add(log);
                }
            }

            letterList.sort((s1, s2) -> {
                /*
                split 에 두 번째 파라미터로 limit 값을 넣어주면 limit 값에 맞게 등분 된다.
                ex) let1 art can 이라는 문자열이 있을 경우.
                 아래에서는 limit 을 2로 주었으므로 문자열이 이등분되어
                 index 0 : let1 / index1 : art can  이 된다.
                 */
                String[] s1x = s1.split(" ", 2);
                String[] s2x = s2.split(" ", 2);
                int compared = s1x[1].compareTo(s2x[1]);
                // 같으면 0, 비교 대상(s2x)가 더 크다면 음수, 비교 대상이 더 작다면 양수를 리턴한다.
                System.out.println("s1x : " + s1x[1] + " / s2x : " + s2x[1]);
                System.out.println(compared);
                if (compared == 0) {
                    return s1x[0].compareTo(s2x[0]);
                } else {
                    return compared;
                }
            });

            letterList.addAll(digitList);
            return letterList.toArray(new String[0]);
        }
    }

}
