package algorithm.java.leetcode.easy;

public class ValidPalindrome {
    /*
        System.out.println("125번 Valid Palindrome : ");
//        String s = "A man, a plan, a canal: Panama";
        String s = "race a car";
//        String s = " ";
        System.out.println(ValidPalindrome.isPalindrome(s));
        System.out.println("------------------------");
     */

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

    public boolean isPalindrome(String s) {
        //공백 제거
        //소문자로 변환
        //특수문자 제거
        //공백일경우 ture.
        //절반으로 쪼갠 뒤 한쪽을 리버스하고 일치하는지 확인하기
        String value1 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (value1.equals("")) {
            return true;
        }
        StringBuilder value2 = new StringBuilder(value1).reverse();
        System.out.println(value1 + " / " + value2);

        //contentEquals : CharSequence 인터페이스를 구현하고 있는 객체들을 비교한다. (String, StringBuilder, StringBuffer, Char .. )
        return value1.contentEquals(value2);
    }

    public static class BookAnswer {


        public boolean isPalindrome1(String s) {
            return true;
        }

        public boolean isPalindrome2(String s) {
            String s_filtered = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
            String s_reversed = new StringBuilder(s_filtered).reverse().toString();
            System.out.println(s_filtered + " / " + s_reversed);
            return s_filtered.equals(s_reversed);
        }

    }

    public static class LeetCodeFestestAnswer{
        public boolean isPalindromeFastestOfAnswer(String s){

            s = s.toLowerCase();

            StringBuilder real = new StringBuilder();

            for(Character c : s.toCharArray()){
                if(Character.isLetterOrDigit(c)){
                    real.append(c);
                }
            }

            int start = 0;
            int end = real.length() - 1;

            while(start <= end){
                char first = real.charAt(start);
                char second = real.charAt(end);

                if(first != second){
                    return false;
                }

                start++;
                end--;
            }

            return true;
        }

    }
}

