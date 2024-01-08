package algorithm.kotlin.leetcode.easy

class MostCommonWord {
    /*
        val paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    val banned = arrayOf("hit")
    val m = MostCommonWord()
    print( m.mostCommonWord(paragraph, banned))

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
        val m = mutableMapOf<String, Int>()

        val regex = "[^a-zA-Z]"
        val x = "\\s+"
        val str = paragraph.lowercase().replace(regex.toRegex(), " ").split(x.toRegex())
        str.filter {
            !banned.contains(it)
        }.forEach {
            m[it] = m.getOrDefault(it, 0) + 1
        }

        return m.maxBy { it.value }.key
    }

    class BookAnswer{
        fun mostCommonWord(paragraph: String, banned: Array<String>): String {
            val counts: MutableMap<String, Int> = mutableMapOf()
            //toLowerCase -> lowerCase 로 변경됨.
            val words = paragraph.replace("\\W+".toRegex(), " ").toLowerCase().trim().split(" ")
            for (w in words){
                if (!banned.contains(w)) {
                    counts[w] = counts.getOrDefault(w, 0) + 1
                }
            }
            return counts.maxByOrNull { it.value }!!.key
            //리턴 값이 nullable 하므로 리턴값이 항상 존재하는 해당 문제와 같은 경우가 아니라면 null 처리를 해주는 것이 필요하다.
        }
    }

}