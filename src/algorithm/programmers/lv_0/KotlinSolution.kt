package algorithm.programmers.lv_0

class Kotlin_Solution {}

//Q. 문자열 출력하기
//// 답 1.
//fun main(args: Array<String>) {
//    println(readLine(args)!!)
//}
//
//fun readLine(args: Array<String>): String? {
//    return args.joinToString()
//}
//// 답 2.
//    fun main(args: Array<String>) {
//        readlnOrNull()?.let (::println)
//        //답 2-2.
//        readLine()?.let(::println)
//    }
/**
 * readLine() : Kotlin의 표준 라이브러리 함수. 콘솔의 입력값을 읽어올 때 사용한다. 자바의 Scanner 랑 비슷한 것 같다.
 * -> 1.6.0 부터 readln() 이 새로 추가되었다. readLine() 은 점차 사용하지 않을 것으로 추측된다.
 * readln() : 1.6.0 부터 추가된 Kotlin의 표준 라이브러리 함수.  콘솔의 입력값을 읽어올 때 사용한다. readLine()!! 과 같다. not null 임.
 * readlnOrNull() : 1.6.0 부터 추가된 Kotlin의 표준 라이브러리 함수. 콘솔의 입력값을 읽어올 때 사용한다. readLine() 과 같다.
 * https://soopeach.tistory.com/44
 */


//Q. a와 b 출력하기
//fun main(args: Array<String>) {
////        답 1.
//    val (a, b) = readLine()!!.split(' ').map(String::toInt)
//////        답 2.
////    readlnOrNull()?.let {
////        val (a, b) = it.split(' ').map(String::toInt)
////        println("a = $a")
////        println("b = $b")
////    }
//}


//Q. 문자열 반복해서 출력하기
fun main(args: Array<String>) {
    //답 1.
//    val input = readLine()!!.split(' ')
//    val s1 = input[0]
//    val a = input[1]!!.toInt()
//    for (x in 1 .. a){
//        print(s1)
//    }

    //답 2.
    readlnOrNull()?.let {
        val input = it.split(' ')
        if (input.size > 1) {
            val s = input[0]
            val n = input[1].toInt()
            //답 2-1
//            for (x in 1 .. n){
//                print(s)
//            }
            //답 2-2
//            print(s.repeat(n))
        }
    }
}



