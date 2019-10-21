package com.charlotte;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        boolean res = isValid("{[]}");
        System.out.println(res);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() == 0)
            return false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;

                if (c=='}'){
                    if (stack.peek() != '{'){
                        return false;
                    }else {
                        stack.pop();
                    }
                }
                else if (c==']'){
                    if (stack.peek() != '['){
                        return false;
                    }else {
                        stack.pop();
                    }
                }
                else if (c==')'){
                    if (stack.peek() != '('){
                        return false;
                    }else {
                        stack.pop();
                    }
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
