package algorithm_quiz.java.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

	/*
		1481. Least Number of Unique Integers after K Removals
	*/

public class LeastNumberOfUniqueIntegersAfterKRemovals {

	public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> l = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        for (Map.Entry<Integer, Integer> n: l) {
            if (n.getValue() <= k) {
                k -= n.getValue();
                map.remove(n.getKey());
            } else break;
        }
        return map.size();
    }

}