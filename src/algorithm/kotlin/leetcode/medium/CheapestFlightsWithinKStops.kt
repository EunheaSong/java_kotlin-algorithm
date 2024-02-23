package algorithm.kotlin.leetcode.medium

import java.util.*

class CheapestFlightsWithinKStops {
    /*
    787. Cheapest Flights Within K Stops
     */
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        // Build graph
        val graph: Array<MutableList<IntArray>> = Array(n) { mutableListOf<IntArray>() }
        for ((from, to, cost) in flights) {
            graph[from].add(intArrayOf(to, cost))
        }

        // BFS
        //n개 만큼의 intArray 를 생성. 요구사항이 실패했는지 구분하기 위해 모든 인덱스에는 Int의 max value 를 넣어준다.
        var cheapest = IntArray(n) { Int.MAX_VALUE }
        //이용된 루트는 지워주기 위해 poll 함수를 사용을 하려, LinkedList 를 이용.
        var queue = LinkedList<IntArray>()
        //while 문을 src 로 시작하기 위한 더미 데이터 삽입.
        queue.add(intArrayOf(src, 0, -1))
        while (queue.isNotEmpty()) {
            val (loc, cost, stops) = queue.poll()
            //k 는 지날 수 있는 노드의 갯수이기때문에, k 보다 많은 노드를 지날 수 없다.
            if (stops > k || cost >= cheapest[loc]) {
                continue
            }
            //노트에 도착하기까지 걸린 비용을 해당 노드번호와 일치하는 인덱스에 넣어준다.
            cheapest[loc] = cost
            for ((dest, price) in graph[loc]) {
                queue.add(intArrayOf(dest, cost + price, stops + 1))
            }
        }
        return if (cheapest[dst] == Int.MAX_VALUE) -1 else cheapest[dst]
    }

    fun findCheapestPrice2(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        var dist = IntArray(n) { Int.MAX_VALUE }
        dist[src] = 0

        for (i in 0..k) {
            val temp = dist.copyOf()
            flights.forEach { (from, to, cost) ->
                if (dist[from] == Int.MAX_VALUE) return@forEach
                temp[to] = Math.min(temp[to], dist[from] + cost)
            }
            dist = temp
        }
        return if (dist[dst] == Int.MAX_VALUE) -1 else dist[dst]
    }
}