import exceptions.InvalidNotationFormatException;
import exceptions.StackUnderflowException;

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

        infix += ")";
        stack.push('(');

        char[] charArray = infix.toCharArray();

        for (char character : charArray) {

            //if operand is found
            if (character == '1' || character == '2' || character == '3' ||
                    character == '4' || character == '5' || character == '6' ||
                    character == '7' || character == '8' || character == '9') {


                queue.enqueue(character);

            }

            //if left parenthesis is found
            else if (character == '(') {
                stack.push(character);
            }

            //if operators is found
            else if (character == '+' || character == '-' || character == '*' || character == '/') {
                if (character == '+' || character == '-') {
                    try {
                        while (stack.top() != '(') {
                            queue.enqueue(stack.pop());
                        }
                    } catch (StackUnderflowException exception) {
                    } finally {
                        stack.push(character);
                    }
                } else if (character == '*' || character == '/') {
                    try {
                        while (stack.top() == '*' || stack.top() == '/') {
                            queue.enqueue(stack.pop());
                        }
                    } catch (StackUnderflowException exception) {
                    } finally {
                        stack.push(character);
                    }
                }
            }

            //if right parenthesis is found
            else if (character == ')') {
                try {
                    while (stack.top() != '(') {
                        queue.enqueue(stack.pop());
                    }
                    stack.pop();
                } catch (StackUnderflowException exception) {
                    throw new InvalidNotationFormatException();
                }

            }
        }

        postfix = queue.toString();
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

        NotationStack<String> stack = new NotationStack<>();
        String infix = "";

        for (int i = 0; i < postfix.length(); i++) {
            Character character = postfix.charAt(i);
            //if operand found
            if (character == '1' || character == '2' || character == '3' ||
                    character == '4' || character == '5' || character == '6' ||
                    character == '7' || character == '8' || character == '9') {

                stack.push(character.toString());
            }

            //if operators is found
            else if (character == '+' || character == '-' || character == '*' || character == '/') {
                if (stack.size() < 2)
                    throw new InvalidNotationFormatException();
                else {
                    String rightOperand = stack.pop();
                    String leftOperand = stack.pop();
                    String operation = "(" + leftOperand + character + rightOperand + ")";

                    stack.push(operation);
                }
            }
        }

        if (stack.size() == 1)
            infix = stack.toString();
        else
            throw new InvalidNotationFormatException();

        return infix;
    }


    /**
     * Evaluates a postfix expression from a string to a double
     *
     * @param postfixExpr - the postfix expression in String format
     * @return the evaluation of the postfix expression as a double
     * @throws InvalidNotationFormatException - if the postfix expression format is invalid
     */
    public static double evaluatePostfixExpression(String postfixExpr) {

        NotationStack<Character> stack = new NotationStack<>();

        double result = 0;
        char[] charArray = postfixExpr.toCharArray();

        for (int i = 0; i < postfixExpr.length(); i++) {

            Character character = postfixExpr.charAt(i);

            //if operand or left parenthesis found
            if (character == '1' || character == '2' || character == '3' ||
                    character == '4' || character == '5' || character == '6' ||
                    character == '7' || character == '8' || character == '9' ||
                    character == '(') {

                stack.push(character);
            }


            //if operator is found
            else if (character == '+' || character == '-' || character == '*' || character == '/') {
                if (stack.size() < 2)
                    throw new InvalidNotationFormatException();
                else {
                    double rightOperand = Character.getNumericValue(stack.pop());
                    double leftOperand = Character.getNumericValue(stack.pop());

                    if (character == '+') {
                        Double operationResult = leftOperand + rightOperand;
                        stack.push(operationResult.toString());
                    } else if (character == '-') {
                        Double operationResult = leftOperand - rightOperand;
                        stack.push(operationResult.toString());
                    } else if (character == '*') {
                        Double operationResult = leftOperand * rightOperand;
                        stack.push(operationResult.toString());
                    } else if (character == '/') {
                        Double operationResult = leftOperand / rightOperand;
                        stack.push(operationResult.toString());
                    }

                }
            }
        }


        if (stack.size() == 1) {
            result = Character.getNumericValue(stack.pop());
        } else {
            throw new InvalidNotationFormatException();
        }

        return result;
    }

}
