package algorithm.java.leetcode.easy;

public class ValidParentheses {
    /*
    20. Valid Parentheses
    */
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cc = s.charAt(i);
            switch (cc) {
                case '(' :
                case '{' :
                case '[' :
                    stack.push(cc); 
                    break;
                case ')' : if (stack.isEmpty() || stack.pop() != '(') return false; else break;
                case '}' : if (stack.isEmpty() || stack.pop() != '{') return false; else break;
                case ']' : if (stack.isEmpty() || stack.pop() != '[') return false; else break;
            }
        }
        return (stack.isEmpty()) ? true : false;
    }
}
