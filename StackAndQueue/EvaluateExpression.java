package StackAndQueue;

import java.util.Stack;

public class EvaluateExpression {

    public static void main(String[] args) {

        String[] A1 = { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(A1));
        String[] A2 = { "4", "13", "5", "/", "+" };
        System.out.println(evalRPN(A2));
    }

    public static int evalRPN(String[] A) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : A) {
            if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(token, operand1, operand2);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    
    private static int performOperation(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                return 0;
        }
    }
}