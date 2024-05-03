package algorithm_quiz.java.leetcode.easy;

import java.util.Stack;

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
    
    public static class OtherPeopleAnswer {
    	public boolean isValid(String s) {
    		Stack<Character> stack = new Stack<Character>();
    		for (char c : s.toCharArray()) {
    			if (c == '(')
    				stack.push(')');
    			else if (c == '{')
    				stack.push('}');
    			else if (c == '[')
    				stack.push(']');
    			else if (stack.isEmpty() || stack.pop() != c)
    				return false;
    		}
    		return stack.isEmpty();
    	}
    }
}
