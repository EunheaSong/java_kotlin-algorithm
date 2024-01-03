package algorithm.java;

import algorithm.java.leetcode.easy.*;
import algorithm.java.leetcode.medium.*;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        String o = "own";
//        String a = "art";
//        System.out.println(o.compareTo(a));
//        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
//        String[] logs = {"j je", "b fjt", "7 zbr", "m le", "o 33"};
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        ReorderDataInLogFiles r = new ReorderDataInLogFiles();
        String[] answer = r.reorderLogFiles(logs);
//        System.out.println(r.reorderLogFiles(logs));
        for (String s : answer) {
            System.out.println(s);
        }
//        List<String> a = new LinkedList<>();
//        a.add("a")
//        a.add("c");
//        a.add("d");
//        for (int i = 0; i < 3; i++){
//            String s = a.get(i);
//            System.out.println("1 : " + s);
//
//            if (s.compareTo("b") < 0) {
//                System.out.println("2 : " + s);
////                a.add(i, s);
//                a.add(i+1, "b");
//                System.out.println("3 : " + i + a.get(i));
//            }
//        }
////        for (String s : a) {
////            System.out.println(s);
////            if (s.compareTo("b") < 0) {
////                String x = s;
////                a.add(i, "b");
////                a.add(i+1, x);
////            }
////            i++;
////            System.out.println(i);
////        }
//        System.out.println("=======");
//
//        for (String s : a) {
//            System.out.println(s);
//        }
    }
}
