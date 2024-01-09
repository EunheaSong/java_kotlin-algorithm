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

}

