package algorithm.java.leetcode.medium;

public class LongestPalindromicSubstring {
    /*
    String  s = "babad";
//    String s = "cbbd";
//    String s = "xiqhechagdpbcdthaafmcnplenylepawbafsmxqlwhzgqmuemwolgoockcafchdsfggulwfzwwkvivnwgbelbbydzfkcfsschvbantskuosunhqihmqjmzgavfnonwhwrkfxgcbowfsebthbrhhklxxyoxiphrgxqodulrbbvdwcclpyjhljgyypztbqzkiyzbfnvnoargyyakaidkiyleurvjbadzwqjtrluayhblhdokmwrwhassruxpftwlbalfvwxtfcqibywsusrlwmbcibvgwnmmdmuhswuperbjoxarhqcpcebbtyhnrouvuwftspmzsmdhfcqovffkuikzrcweffmpnjldoalhcvqvjavllvajvqvchlaodljnpmffewcrzkiukffvoqcfhdmszmpstfwuvuornhytbbecpcqhraxojbrepuwshumdmmnwgvbicbmwlrsuswybiqcftxwvflablwtfpxurssahwrwmkodhlbhyaulrtjqwzdabjvruelyikdiakayygraonvnfbzyikzqbtzpyygjlhjyplccwdvbbrludoqxgrhpixoyxxlkhhrbhtbesfwobcgxfkrwhwnonfvagzmjqmhiqhnusoukstnabvhcssfckfzdybblebgwnvivkwwzfwluggfsdhcfackcooglowmeumqgzhwlqxmsfabwapelynelpncmfaahtdcbpdgahcehqix";
//    String s = "ac";
//    String s = "abb";
    LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
    System.out.println(lps.longestPalindrome2(s));

    5. Longest Palindromic Substring

    Given a string s, return the longest palindromic substring  in s.

    Example 1:
    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.

    Example 2:
    Input: s = "cbbd"
    Output: "bb"

    Constraints:
    1 <= s.length <= 1000
    s consist of only digits and English letters.
     */

    //해당 방식은 문자열이 길면 타임아웃으로 실패.
    public String longestPalindrome(String s) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            int j = s.length();
            while (i <= j) {
                String str = s.substring(i, j);
                StringBuilder reverseStr = new StringBuilder(str).reverse();
                if (str.contentEquals(reverseStr)) {
                    answer = (answer.length() > str.length()) ? answer : str;
                    break;
                }
                j--;
            }
        }
        return answer;
    }

    public String pointer(String s, int i, int j) {
        String str = "";
        //앞 뒤 문자가 같으면 좌우로 확장한다.
        while (0 <= i && j <= s.length() && s.charAt(i) == s.charAt(j -1)) {
            str = s.substring(i, j);
            i--;
            j++;
        }
        return str;
    }

    public String longestPalindrome2(String s) {
        //주어진 문자열이 1개의 문자라면 그대로 반환.
        if (s.length() < 2) {
            return s;
        }

        //주어진 문자열 중 가장 큰 팰린드롬이 문자열 하나일 경우가 있고, 해당 경우가 있을 수 있는 가장 짧은 팰린드롬이므로 기본으로 지정.
        //ex) "abc" -> a 혹은 b 혹은 c 가 답.
        String answer = s.substring(0, 1);
        //2칸 짜리 포인터
        //3칸 짜리 포인터
        //앞 뒤 문자가 같으면 양옆으로 확장. or 우측으로 한칸씩 이동.
        //문자열의 길이를 체크해서 마지막 이동인지 확인.
        for (int i = 0; i < s.length(); i++) {
            //2칸 짜리 포인터
            String s1 = pointer(s, i, i + 2);
            //3칸 짜리 포인터
            String s2 = pointer(s, i, i + 3);
            String ss = (s1.length() > s2.length()) ? s1 : s2;
            answer = (ss.length() > answer.length()) ? ss : answer;
        }

        return answer;
    }

    public static class BookAnswer {
        /*
        dynamic programming 을 사용해도 되지만,
        해당 문제의 경우 보다 더 빠르게 해결할 수 있는 Tow pointer 개념을 사용한다.

        dynamic programming :
        중복된 문제들 중 최적의 해결법을 찾는 알고리즘.
        ex) 피보나치 수열,
            같은 행위를 하며 모든 경우의 수를 찾을 때.
            (여러 경로 중 최단 거리 찾기, 일정 공간을 가득 체울 수 있는 방법 찾기 등.. )

        Tow Pointer :
        두 가지 포인터를 사용하여 스캔하는 방식.
         */

        //문제에서 전체적으로 사용하기 위해 멤버변수로 선언한다.
        int left, maxLen;

        public void extendPalindrome(String s, int j, int k) {
            //투 포인터가 유요한 범위 내에 있고 양쪽 끝 문자가 일치하는 팰린드롬인 경우, 범위 확장.
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
            }
            if (maxLen < k - j - 1) {
                left = j + 1;
                maxLen = k - j - 1;
            }
        }

        public String longestPalindrome(String s) {
            int len = s.length();
            //주어지는 문자열이 문자 한개라면 그대로 반환.
            if (len < 2) return s;
            for (int i = 0; i < len; i++) {
                extendPalindrome(s, i, i + 1);
                extendPalindrome(s, i, i + 2);
            }
            return s.substring(left, left + maxLen);
        }
    }
}

