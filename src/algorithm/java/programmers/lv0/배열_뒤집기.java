package algorithm.java.programmers.lv0;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class 배열_뒤집기 {

    public int[] solution(int[] num_list) {
        int index = num_list.length -1;
        int[] answer = new int[num_list.length];
        for (int i: num_list) {
            answer[index] = i;
            index--;
        }
        return answer;
    }

    static class OtherPeopleAnswer {
        public int[] solution(int[] numList) {
            List<Integer> list = Arrays.stream(numList).boxed().collect(Collectors.toList());

            Collections.reverse(list);
            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        public int[] solution2(int[] num_list) {
            return LongStream.range(1, num_list.length + 1)
                .mapToInt(i -> num_list[(int) (num_list.length - i)])
                .toArray();
        }
    }
}
