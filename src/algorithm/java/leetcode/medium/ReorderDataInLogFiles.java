package algorithm.java.leetcode.medium;

import java.util.*;

public class ReorderDataInLogFiles {
    /*
        System.out.println("937번 Reorder Data in Log Files : ");
        String[] logs = {"j je", "b fjt", "7 zbr", "m le", "o 33"};
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
        //첫 문자열은 구분자

        // key value 로 만들어야할까?
        //["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
        //["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
        //["a8 act zoo","g1 act car","zo4 4 7","ab1 off key dog","a1 9 2 3 1"]
        //["a8 act zoo","g1 act car","zo4 4 7","ab1 off key dog","a1 9 2 3 1"]
        // 4,2,5,6,1,3
        // 4
        // 2,4
        // 2,4,5
        // 2,4,5,6
        //"j je", "b fjt", "7 zbr", "m le", "o 33"
        //j je
        //"b fjt, j je,


        List<String> a = new LinkedList<>();
        List<String> b = new ArrayList<String>();
        System.out.println("Start!");
        for (int i = 0; i < logs.length; i++){
            System.out.println(i);
            String log = logs[i];
            String[] l = log.split(" ");
            char[] c = l[1].toCharArray();
            System.out.println(c[0]);
            if (Character.isDigit(c[0])){
                b.add(log);
                System.out.println("continue : " + log);
                continue;
            }
            if (a.isEmpty()){
                a.add(log);
            }
            for(int j = 0; j < a.size(); j++) {
                if (log.equals(a.get(j))) {
                    continue;
                }
                System.out.println("a.size : " + a.size());
                String[] l2 = a.get(j).split(" ");
                int t = test(l, l2);
                if (t > 0) {
                    // l 이 l2 보다 클 경우.
                    //
                    int x = t;
                    int y = 1;
                    while (x > 0){
                        if (j+y == a.size()){
                            a.add(j + y, log);
                            break;
                        }
                        x = test(l, a.get(j+y).split(" "));
                        if (x <= 0) {
//                            a.add(j+y+1, a.get(j+y));
                            a.add(j+y, log);
                        }
                        y++;
                    }
                    System.out.println("if : " + (j+1) + " " + log);
                    for (String s : a) {
                        System.out.println(s);
                    }
                    break;

                } else if (t < 0){
                    for (String s : a) {
                        System.out.println(s);
                    }
                    // l 이 l2 보다 작거나 같을 경우.
//                    a.add(j + 1, a.get(j));
                    System.out.println("else if :" + a.get(j));

                    a.add(j, log);
                    System.out.println("else if :" + j + log);

                    for (String s : a) {
                        System.out.println(s);
                    }
                    break;
                } else {
                    // 로그 내용이 다 같을 경우. 식별자로 구분.
                    int q = l[0].compareTo(l2[0]);
                    if (q > 0) {
                        a.add(j + 1, log);
                    } else {
//                        a.add(j + 1, a.get(j));
                        a.add(j, log);
                    }
                    break;
                }
            }
            System.out.println("===============");
//            break;
        }
        a.addAll(b);
        return a.toArray(new String[a.size()]);
    }

    public int test(String[] x, String[] y){
        for (int i = 1; i < x.length; i++) {
            int a = x[i].compareTo(y[i]);
            if (a > 0) {
                return 1;
            } else if (a < 0) {
                // l 이 l2 보다 작을 경우.
                return -1;
            }
            System.out.println("test index : " + i);
        }
        /*
         return (x < y) ? -1 : ((x == y) ? 0 : 1);
         */
        return Integer.compare(x.length, y.length);
    }


}
