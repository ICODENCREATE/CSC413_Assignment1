package ExpressionEvaluator;

public class ExpressionEvaluator {
    public static final String INFIX_EXPRESSION = "(a+b) * (c+d)";
    public static final String POSTFIX_EXPRESSION = "ac - b^d+";

    public static String getInfixExpression(){
        return INFIX_EXPRESSION;
    }

    public static String getPostfixExpression() {
        return POSTFIX_EXPRESSION;
    }

    public static void main(String[] args){
        ExpressionDriver driver = new ExpressionDriver();
        driver.evaluateExpression();
    }
}

