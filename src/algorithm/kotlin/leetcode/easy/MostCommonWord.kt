package algorithm.kotlin.leetcode.easy

class MostCommonWord {
    /*

    Example 1:
    Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
    Output: "ball"
    Explanation:
    "hit" occurs 3 times, but it is a banned word.
    "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
    Note that words in the paragraph are not case sensitive,
    that punctuation is ignored (even if adjacent to words, such as "ball,"),
    and that "hit" isn't the answer even though it occurs more because it is banned.

    Example 2:
    Input: paragraph = "a.", banned = []
    Output: "a"

     */
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val regex = "[^a-zA-Z]"
        val x = "\\s+"
        val str = paragraph.lowercase().replace(regex.toRegex(), " ").split(x.toRegex())

        return ""
    }
}