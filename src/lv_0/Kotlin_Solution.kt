package lv_0

class Kotlin_Solution {
    // 문자열 출력하기
    // 답 1.
//    fun main(args: Array<String>) {
//        println(readLine(args)!!)
//    }
//    fun readLine(args: Array<String>): String? {
//        return args.joinToString()
//    }
    // 답 2.
    fun main(args: Array<String>) {
        readlnOrNull()?.let (::println)
//        //답 2-2.
//        readLine()?.let(::println)
    }
    /**
     * readLine() : Kotlin의 표준 라이브러리 함수. 콘솔의 입력값을 읽어올 때 사용한다. 자바의 Scanner 랑 비슷한 것 같다.
     * -> 1.6.0 부터 readln() 이 새로 추가되었다. readLine() 은 점차 사용하지 않을 것으로 추측된다.
     * readln() : 1.6.0 부터 추가된 Kotlin의 표준 라이브러리 함수.  콘솔의 입력값을 읽어올 때 사용한다. readLine()!! 과 같다. not null 임.
     * readlnOrNull() : 1.6.0 부터 추가된 Kotlin의 표준 라이브러리 함수. 콘솔의 입력값을 읽어올 때 사용한다. readLine() 과 같다.
     * https://soopeach.tistory.com/44
     */

}