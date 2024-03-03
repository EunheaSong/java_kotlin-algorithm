package algorithm.java.leetcode.easy;

public class PlusOne {
    /*
    66. Plus One
     */

    public int[] plusOne(int[] digits) {
        int addInt = 0;
        int j = 1;
        for (int i = digits.length-1; 0 <= i; i--) {
            addInt += digits[i] * j;
            System.out.println();
            j *= 10;
        }
        addInt += 1;
        String a = Integer.toString(addInt);
        char[] c = a.toCharArray();
        int[] newDigits = new int[c.length];
        for (int i = 0; i < c.length-1; i++) {
            newDigits[i] = c[i] - 49;
        }
        return newDigits;
    }

}
