package algorithm_quiz.kotlin.leetcode.easy


class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        val ss = s.lowercase().replace(Regex("[^a-z0-9]"), "")
        if (ss.isEmpty()) return true
        return ss == ss.reversed()
    }

    fun isPalindrome2(s: String): Boolean {
        val ss = s.lowercase().replace(Regex("[^a-z0-9]"), "")
        var start = 0
        var end = s.length
        while (start < end) {
            if (ss[start] != ss[end]) return false
            start++
            end--
        }
        return true
    }
}