package algorithm.java.leetcode.easy;

public class AddBinary {
    /*
    67. Add Binary
    Example 1:
    Input: a = "11", b = "1"
    Output: "100"
    Example 2:
    Input: a = "1010", b = "1011"
    Output: "10101"
     */

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int al = a.length() -1;
        int bl = b.length() -1;
        int x = 0;
        while (0 <= al || 0 <= bl) {
            int y = x;
            if (0 <= al) {
                y += a.charAt(al--) - '0';
                // -'0' 을 해주고 있기 때문에 a.charAt(al) 이 '0' -> 0 , '1' -> 1 이 될 것.
            }
            if (0 <= bl) {
                y += b.charAt(bl--) - '0';
            }
            if (y > 1) {
                x = 1;
                sb.append(y-2);
                //y > 1 인 경우, y = 2 또는 y = 3 일 것이므로 y-2 를 해준다.
            } else {
                x = 0;
                sb.append(y);
            }
        }
        if (x != 0) sb.append(x);
        return sb.reverse().toString();
    }

}
