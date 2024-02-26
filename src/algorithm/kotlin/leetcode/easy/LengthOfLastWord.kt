package algorithm.kotlin.leetcode.easy

class LengthOfLastWord {
    /*
    58. Length of Last Word
     */

    fun lengthOfLastWord(s: String): Int {
//        val array = s.trim().split("\\s+".toRegex())
//        toRegex() 를 이용하면 정규표현식으로 split 을 할 수 있다.
        val array = s.trim().split(" ")
        return array[array.size-1].length
    }

    fun lengthOfLastWord2(s: String): Int {
        var count = 0
        for (i in s.length - 1 downTo 0) {
            if (s[i] != ' ') count++
            else if (count > 0) return count
        }
        return count
    }
}