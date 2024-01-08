package algorithm.kotlin.leetcode.easy

class ReversString {

    /*
    val chars = charArrayOf('h','e','l','l','o')
//    val chars = charArrayOf('H','a','n','n','a','h')
    val rs = ReversString()
    rs.reversStrung(chars)

    You must do this by modifying the input array in-place with O(1) extra memory.
    Example 1:
    Input: s = ["h","e","l","l","o"]
    Output: ["o","l","l","e","h"]
    Example 2:
    Input: s = ["H","a","n","n","a","h"]
    Output: ["h","a","n","n","a","H"]

    Constraints: 1 <= s.length <= 105
    s[i] is a printable ascii character.
 */
    fun reversStrung(s : CharArray) {
        var index = s.size -1
        val size = if (s.size % 2 == 0) s.size / 2  else (s.size -1) / 2
        for (i: Int in 0..< size){
            val x = s[i]
            s[i] = s[index]
            s[index] = x
            index--
        }
        print(s)
    }
}