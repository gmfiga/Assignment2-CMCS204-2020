import exceptions.InvalidNotationFormatException;

public class Notation {

    public Notation() {
    }

    /**
     * Convert an infix expression into a postfix expression
     * @param infix - the infix expression in string format
     * @return the postfix expression in string format
     * @throws InvalidNotationFormatException - if the infix expression format is invalid
     */

    //MUST use a queue for the internal structure that holds the postfix solution.
    //Then use the toString method of the Queue to return the solution as a string.
    public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
        return "";
    }

    /**
     * Convert the Postfix expression to the Infix expression
     * @param postfix - the postfix expression in string format
     * @return the infix expression in string format
     * @throws InvalidNotationFormatException - if the postfix expression format is invalid
     */

    public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
        return "";
    }

    /**
     * Evaluates a postfix expression from a string to a double
     * @param postfixExpr - the postfix expression in String format
     * @return the evaluation of the postfix expression as a double
     * @throws InvalidNotationFormatException - if the postfix expression format is invalid
     */
    public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
        return 0;
    }
}
