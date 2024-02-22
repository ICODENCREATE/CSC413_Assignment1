package ExpressionEvaluator;

import java.util.Stack;

class InfixEvaluator {
    public static int evaluateInfix(String str, int a, int b, int c, int d){
        Stack<Character> operatorStack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();

        for (char x : str.toCharArray()){
            if (Character.isLetter(x)){
                switch (x){
                    case 'a':
                        valueStack.push(a);
                        break;

                    case 'b':
                        valueStack.push(b);
                        break;

                    case 'c':
                        valueStack.push(c);
                        break;

                    case 'd':
                        valueStack.push(d);
                        break;

                    default:
                        break;
                }
            }
            else if (x == '+' || x == '-' || x == '*' || x == '/') {
                operatorStack.push(x);
            }
            else if (x == ')'){
                int val1 = valueStack.pop();
                int val2 = valueStack.pop();
                char operator = operatorStack.pop();
                int result = evaluate(val1, val2, operator);
                valueStack.push(result);
            }
        }
        return valueStack.pop();
    }
    private static int evaluate(int val1, int val2, char operator){
        switch (operator){
            case '+':
                return val1 + val2;
            case '-':
                return val1 - val2;
            case '*':
                return val1 * val2;
            case '/':
                return val1 / val2;
            default:
                return 0;
        }
    }
}