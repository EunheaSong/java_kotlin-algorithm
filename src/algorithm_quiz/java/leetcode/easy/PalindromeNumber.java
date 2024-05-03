package algorithm_quiz.java.leetcode.easy;

public class PalindromeNumber {
    /*
    9. Palindrome Number
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = Integer.toString(x);
        int start = 0;
        int end = s.length()-1;
        while(start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    static class LeetCodeFastestAnswer {

        public boolean isPalindrome(int x) {
            if(x<0){
                return false;
            }

            int temp=x;
            int rev=0;
            while(x!=0)
            {
                rev=rev*10+x%10;
                x/=10;
            }
            return(temp==rev);

        }
    }
}
