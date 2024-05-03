package algorithm_quiz.java.leetcode.easy;

public class PlusOne {
    /*
    66. Plus One
     */

    //데이터 범위가 초과되어 실패.
//    public int[] plusOne(int[] digits) {
//        int addInt = 0;
//        int j = 1;
//        for (int i = digits.length - 1; 0 <= i; i--) {
//            addInt += digits[i] * j;
//            System.out.println();
//            j *= 10;
//        }
//        addInt += 1;
//        String a = Integer.toString(addInt);
//        char[] c = a.toCharArray();
//        int[] newDigits = new int[c.length];
//        for (int i = 0; i < c.length - 1; i++) {
//            newDigits[i] = c[i] - 49;
//        }
//        return newDigits;
//    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
