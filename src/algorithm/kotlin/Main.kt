package algorithm.kotlin

class Main {
}

fun main() {
    val paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    val regex = "[^a-zA-Z]"
    val x = "\\s+"
    val str = paragraph.lowercase().replace(regex.toRegex(), " ").split(x.toRegex())

    print(str)
}