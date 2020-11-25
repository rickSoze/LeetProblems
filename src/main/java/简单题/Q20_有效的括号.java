package 简单题;

import java.util.Stack;

public class Q20_有效的括号 {
    //简化代码
    class Solution {
        public boolean isValid(String s) {
            if (s.length()==0|| "".equals(s)) return true;
            Stack<Character> stack = new Stack<>();
            char[] c = s.toCharArray();
            for (int i = 0; i <c.length; i++) {
                if (c[i]=='(' ||c[i]=='['||c[i]=='{'){
                    stack.push(c[i]);
                }
                if (stack.isEmpty()) {
                    return false;
                }
                if (c[i]==')'){
                    if (stack.pop() != '(') return false;
                }
                if (c[i]=='}'){
                    if (stack.pop() != '{') return false;
                }
                if (c[i]==']'){
                    if (stack.pop() != '[') return false;
                }
            }
            if (!stack.isEmpty()) return false;
            return true;
        }
    }
}
