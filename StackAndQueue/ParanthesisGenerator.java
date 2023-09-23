package StackAndQueue;

import java.util.Stack;

public class ParanthesisGenerator {
    public static void main(String[] args) {
        String A1 = "()[]{}";
        System.out.println(isValid(A1));

        String A2 = "([)])";

        System.out.println(isValid(A2));
    }

    public static int isValid(String A) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (!s.isEmpty()) {
                    char top = s.peek();
                    if ((top == '(' && ch == ')') || (top == '{' && ch == '}') || (top == '[' && ch == ']')) {
                        s.pop();
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }
        }
        if (s.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

}
