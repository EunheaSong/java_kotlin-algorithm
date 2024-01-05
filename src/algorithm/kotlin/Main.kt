package algorithm.kotlin

import algorithm.kotlin.leetcode.easy.MostCommonWord

class Main {
}

fun main() {
    val paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    val banned = arrayOf("hit")
    val m = MostCommonWord()
    print( m.mostCommonWord(paragraph, banned))
}