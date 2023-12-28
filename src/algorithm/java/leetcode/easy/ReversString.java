package algorithm.java.leetcode.easy;

public class ReversString {
    /*
        char[] s = {'h','e','l','l','o'};
        ReversString rs = new ReversString();
        rs.reverseString(s);
     */

    /*
    Example 1:
    Input: s = ["h","e","l","l","o"]
    Output: ["o","l","l","e","h"]
    Example 2:
    Input: s = ["H","a","n","n","a","h"]
    Output: ["h","a","n","n","a","H"]

    Constraints: 1 <= s.length <= 105
    s[i] is a printable ascii character.
     */
    public void reverseString(char[] s) {
        int i = s.length - 1;
        int j = 0;
        /*
        in place algorithm 참고 (https://en.wikipedia.org/wiki/In-place_algorithm)
        array 를 두 개 만들어서 동시에 사용하면 O(n)의 추가 공간을 필요로 하게된다.
        그래서 in place 알고리즘처럼 하나의 어레이로 해결하는 것이 O(1) 을 사용하는 빠른 방법이다.
         */

        while (i >= s.length / 2){
            char c = s[j];
            s[j] = s[i];
            s[i] = c;
            i--;
            j++;
        }
    }
}
