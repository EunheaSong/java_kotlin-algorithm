package lv_0;

import java.util.Scanner;

public class Java_Solution {
    // 문자열 출력하기
    // 답 1.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        if (1 <= a.length() && a.length() <= 1000000){
            System.out.println(a);
        }
    }

}