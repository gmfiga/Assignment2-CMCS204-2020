import exceptions.InvalidNotationFormatException;

import java.util.ArrayList;

public class Notation {

    public Notation() {
    }

    /**
     * Convert an infix expression into a postfix expression
     *
     * @param infix - the infix expression in string format
     * @return the postfix expression in string format
     * @throws InvalidNotationFormatException - if the infix expression format is invalid
     */

    //MUST use a queue for the internal structure that holds the postfix solution.
    //Then use the toString method of the Queue to return the solution as a string.
    public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {

        NotationStack<Character> stack = new NotationStack<>();
        NotationQueue<Character> queue = new NotationQueue<>();
        String postfix = "";

        char[] charArray = infix.toCharArray();

        for (char c : charArray) {

            if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' ||
                    c == '6' || c == '7' || c == '8' || c == '9') {
                queue.enqueue(c);
            }

            else if (c == '(') {
                stack.push(c);
            }

            else if (c== '+'||c== '-'||c== '/'||c== '*') {

                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (c == '+' || c == '-') {
                    ArrayList<Character> tempString = new ArrayList<>();
                    while (!stack.isEmpty()) {
                        tempString.add(stack.pop());
                    }
                    stack.push(c);
                    for (char a : tempString) {
                        stack.push(a);
                    }
                } else if (c == '/' || c == '*') {
                    ArrayList<Character> tempString = new ArrayList<>();
                    while (stack.top() != '-' || stack.top() != '+') {
                        tempString.add(stack.pop());
                    }
                    stack.push(c);
                    for (char a : tempString) {
                        stack.push(a);
                    }
                }

            }

            else if (c == ')') {
                while (!(stack.isEmpty())) {
                    if (stack.top() == '(')
                        stack.pop();
                    queue.enqueue(stack.pop());
                }
            }
    }

    postfix =queue.toString();

        return postfix;
}

    /**
     * Convert the Postfix expression to the Infix expression
     *
     * @param postfix - the postfix expression in string format
     * @return the infix expression in string format
     * @throws InvalidNotationFormatException - if the postfix expression format is invalid
     */

    public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
        return "";
    }

    /**
     * Evaluates a postfix expression from a string to a double
     *
     * @param postfixExpr - the postfix expression in String format
     * @return the evaluation of the postfix expression as a double
     * @throws InvalidNotationFormatException - if the postfix expression format is invalid
     */
    public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
        return 0;
    }
}
