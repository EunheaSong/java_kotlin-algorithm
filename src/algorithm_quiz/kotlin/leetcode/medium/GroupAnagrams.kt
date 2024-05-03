package algorithm_quiz.kotlin.leetcode.medium

class GroupAnagrams {
    /*
    49. Group Anagrams
     */

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
         val map: HashMap<String, List<String>> = hashMapOf()
         strs.forEach {
             val s = it.toCharArray().sorted().joinToString()
             if (!map.containsKey(s)) {
                 map[s] = listOf(it)
             } else {
                 map[s] = map[s]!!.plus(it)
             }
         }
         return map.map { it.value }
    }

    fun groupAnagrams2(strs: Array<String>): List<List<String>> {
        val map: HashMap<String, List<String>> = hashMapOf()
        strs.forEach {
            val s = it.toCharArray().sorted().joinToString()
            map[s] = listOf(it).plus(map.getOrDefault(s, mutableListOf()))
        }
        return map.map { it.value }
    }

}