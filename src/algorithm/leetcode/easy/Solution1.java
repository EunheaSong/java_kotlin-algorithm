package algorithm.leetcode.easy;

public class Solution1{

    public static void main(String[] args) {
        System.out.println("125번 Valid Palindrome : ");
//        String s = "A man, a plan, a canal: Panama";
        String s = "race a car";
//        String s = " ";
        System.out.println(Valid_Palindrome.isPalindrome(s));
        System.out.println("------------------------");


    }

    public static class Valid_Palindrome {
    /*
         Example 1:
         Input: s = "A man, a plan, a canal: Panama"
         Output: true
         Explanation: "amanaplanacanalpanama" is a palindrome.
         Example 2:
         Input: s = "race a car"
         Output: false
         Explanation: "raceacar" is not a palindrome.
         Example 3:
         Input: s = " "
         Output: true
         Explanation: s is an empty string "" after removing non-alphanumeric characters.
         Since an empty string reads the same forward and backward, it is a palindrome.
    */

        /**
         * 125번 Valid Palindrome
         *
         * @param s
         * @return 팰린드롬 문자열이 맞는 가?
         */
        public static boolean isPalindrome(String s) {
            //공백 제거
            //소문자로 변환
            //특수문자 제거
            //공백일경우 ture.
            //절반으로 쪼갠 뒤 한쪽을 리버스하고 일치하는지 확인하기
            String value1 = s.replaceAll("[^a-zA-z]", "").toLowerCase();
            if (value1.equals("")) {
                return true;
            }
            StringBuilder value2 = new StringBuilder(value1).reverse();
            System.out.println(value1 + " / " + value2);

            //contentEquals : CharSequence 인터페이스를 구현하고 있는 객체들을 비교한다. (String, StringBuilder, StringBuffer, Char .. )
            return value1.contentEquals(value2);
        }

        public static boolean isPalindromeBookAnswer1(String s) {
            String s_filtered = s.replaceAll("[^a-zA-z]", "").toLowerCase();
            String s_reversed = new StringBuilder(s_filtered).reverse().toString();
            System.out.println(s_filtered + " / " + s_reversed);
            return s_filtered.equals(s_reversed);
        }

    }
}

