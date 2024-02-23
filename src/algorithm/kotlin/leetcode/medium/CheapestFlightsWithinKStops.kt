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
        var cheapest = IntArray(n) { Int.MAX_VALUE }
        var queue = LinkedList<IntArray>()
        queue.add(intArrayOf(src, 0, -1))
        while (queue.isNotEmpty()) {
            val (loc, cost, stops) = queue.poll()
            if (stops > k || cost >= cheapest[loc]) {
                continue
            }
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