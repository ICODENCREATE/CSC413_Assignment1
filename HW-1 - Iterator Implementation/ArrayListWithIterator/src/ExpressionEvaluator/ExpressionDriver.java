package ExpressionEvaluator;

import java.util.Scanner;

class ExpressionDriver{
    private Scanner scanner;

    public ExpressionDriver(){
        scanner = new Scanner(System.in);
    }

    public void evaluateExpression(){
        String input;
        do {
            System.out.println("Enter your values for identifiers a, b, c, d:");
            int a = getValue("a");
            int b = getValue("b");
            int c = getValue("c");
            int d = getValue("d");

            int infixResult = InfixEvaluator.evaluateInfix(ExpressionEvaluator.INFIX_EXPRESSION, a, b, c, d);
            int postfixResult = PostfixEvaluator.evaluatePostfix(ExpressionEvaluator.POSTFIX_EXPRESSION, a, b, c, d);

            System.out.println("The value of infix string " + ExpressionEvaluator.INFIX_EXPRESSION + " with a = "
                    + a + ", b = " + b + ", c = " + c + ", d = " + d + " is " + infixResult);

            System.out.println("The value of postfix string " + ExpressionEvaluator.POSTFIX_EXPRESSION + " with a = "
                    + a + ", b = " + b + ", c = " + c + ", d = " + d + " is " + postfixResult);

            System.out.println("Add different values? (Y/N):");
            input = scanner.next();
        }
        while (input.equalsIgnoreCase("Y"));

        scanner.close();
    }
    //private int getValue(String a) {
    // System.out.print("Enter value for a: " + a + ": ");
    //return scanner.nextInt();
    //}

    private int getValue(String identifier){
        System.out.print("Enter value for " + identifier + ": ");
        return scanner.nextInt();
    }
}

