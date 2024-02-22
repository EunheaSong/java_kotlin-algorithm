package algorithm.kotlin.leetcode.easy

class FindTheTownJudge {
    /*
    997. Find the Town Judge
     */
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        if ((n - 1) > trust.size) return -1
        if (trust.isEmpty()) return n
        val map = hashMapOf<Int, Int>()
        val set = hashSetOf<Int>()
        trust.forEach {
            set.add(it[0])
            map[it[1]] = map.getOrDefault(it[1], 0) + 1
        }
        if (n <= set.size) return -1
        val m = map.maxBy { it.value }
        return if (m.value == (n-1)) m.key else -1
    }

    fun findJudge2(n: Int, trust: Array<IntArray>): Int {
        //1 <= ai, bi <= n 조건이 있으므로 array에 담기는 숫자는 1 이상이기 때문에 생성되는 배열의 인덱스를 1 더해준다.
        val trustFreq = IntArray(n+1)
        /*
        array trust 의 값들을 꺼내온다.
        trust[i].length == 2 라는 조건이 있으므로,[0, 1] 형태를 맞춰준다.
         */
        for ((from, to) in trust) {
            trustFreq[from]--
            trustFreq[to]++
        }
        //판사를 제외한 모든 주민이 판사를 신뢰한다고 했으므로, n (모든 주민의 수) - 1 (판사) 과 같은 값을 가지는 것을 찾는다.
        for (i in 1 .. n) {
            if (trustFreq[i] == n-1) return i
        }
        return -1
    }
}