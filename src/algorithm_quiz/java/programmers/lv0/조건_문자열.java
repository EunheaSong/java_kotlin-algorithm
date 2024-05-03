package algorithm_quiz.java.programmers.lv0;

import java.util.Map;
import java.util.function.BiFunction;

public class 조건_문자열 {
    public int solution(String ineq, String eq, int n, int m) {
        switch (ineq) {
            case ">":
                if (eq.equals("=")) {
                    return (m <= n) ? 1 : 0;
                } else {
                    return (n > m) ? 1 : 0;
                }
            case "<":
                if (eq.equals("=")) {
                    return (n <= m) ? 1 : 0;
                } else {
                    return (n < m) ? 1 : 0;
                }
            default:
                return 1;
        }
    }

    public int solution_타인의_답(String ineq, String eq, int n, int m) {
        boolean flag = false;

        if (">".equals(ineq) && n > m)
            flag = true;

        if ("<".equals(ineq) && n < m)
            flag = true;

        if ("=".equals(eq) && n == m)
            flag = true;

        return flag ? 1 : 0;
    }

    //기본 조건문보다 상당히 느리다.
    public int solution_타인의_답2(String ineq, String eq, int n, int m) {
        Map<String, BiFunction<Integer, Integer, Boolean>> functions = Map.of(
            ">=", (a, b) -> a >= b,
            "<=", (a, b) -> a <= b,
            ">!", (a, b) -> a > b,
            "<!", (a, b) -> a < b
        );

        return functions.get(ineq + eq).apply(n, m) ? 1 : 0;
    }
}