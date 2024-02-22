package ExpressionEvaluator;

import java.util.Stack;

class PostfixEvaluator {
    public static int evaluatePostfix(String str, int a, int b, int c, int d) {
        Stack<Integer> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (Character.isLetter(x)) {
                switch (x) {
                    case 'a':
                        stack.push(a);
                        break;

                    case 'b':
                        stack.push(b);
                        break;

                    case 'c':
                        stack.push(c);
                        break;

                    case 'd':
                        stack.push(d);
                        break;

                    default:
                        break;
                }
            } else if (x == '+' || x == '-' || x == '*' || x == '/') {
                int val1 = stack.pop();
                int val2 = stack.pop();
                int answer = evaluate(val1, val2, x);
                stack.push(answer);
            }
        }
        return stack.pop();
    }

    private static int evaluate(int val1, int val2, char operator) {
        switch (operator) {
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