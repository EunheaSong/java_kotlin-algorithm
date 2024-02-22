package algorithm.kotlin.leetcode.easy

class FindTheIndexOfTheFirstOccurrenceInAString {
    /*
    28. Find the Index of the First Occurrence in a String
     */

    fun strStr(haystack: String, needle: String): Int {
        haystack.replace(needle, "*").forEachIndexed { index, c ->
            if (c.toString() == "*") return index
        }
        return -1
    }

    fun strStr2(haystack: String, needle: String): Int {
        if (haystack.contains(needle)) return haystack.indexOf(needle)
        return -1
    }

}