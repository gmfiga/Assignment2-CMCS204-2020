import exceptions.StackOverflowException;
import exceptions.StackUnderflowException;

import java.util.ArrayList;

/** Class for a Stack
 *
 * @author Gabriel Martins Figueiredo
 *
 * @param <T> data type
 */
public class NotationStack<T> implements StackInterface {

    private T[] stackArray;
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 50;

    /**
     * constructor takes an int as the size of the stack
     * @param initialCapacity - size of the queue
     */
    public NotationStack(int initialCapacity) {
        T[] tempStack = (T[]) new Object[initialCapacity];
        stackArray = tempStack;
        topIndex = -1;
    }

    /**
     * default constructor - uses a default as the size of the stack
     */
    public NotationStack() {
        T[] tempStack = (T[]) new Object[DEFAULT_CAPACITY];
        stackArray = tempStack;
        topIndex = -1;
    }

    /**
     * takes an ArrayList as a parameter, and fills the Stack with the
     * elements of the ArrayList, First element in the ArrayList is the first element in the Stack
     * @param arrayList - list of items
     */
    public NotationStack(ArrayList<T> arrayList) {
        T[] tempStack = (T[]) new Object[DEFAULT_CAPACITY];
        stackArray = tempStack;
        topIndex = -1;
        fill(arrayList);
    }

    /**
     * Determines if Stack is empty
     * @return true if Stack is empty, false if not
     */
    @Override
    public boolean isEmpty() {
        if (topIndex == -1)
            return true;
        return false;
    }

    /**
     * Determines if Stack is full
     * @return true if Stack is full, false if not
     */
    @Override
    public boolean isFull() {
        if (stackArray.length - 1 == topIndex)
            return true;
        return false;
    }

    /**
     * Deletes and returns the element at the top of the Stack
     * @return the element at the top of the Stack
     */
    @Override
    public T pop() throws StackUnderflowException {

        if (isEmpty())
            throw new StackUnderflowException();

        T top = stackArray[topIndex];
        stackArray[topIndex] = null;
        topIndex -= 1;
        return top;
    }

    /**
     * Returns the element at the top of the Stack, does not pop it off the Stack
     * @return the element at the top of the Stack
     */
    @Override
    public T top() throws StackUnderflowException {
        if (isEmpty())
            throw new StackUnderflowException();
        return stackArray[topIndex];
    }

    /**
     * Number of elements in the Stack
     * @return the number of elements in the Stack
     */
    @Override
    public int size() {
        return topIndex + 1;
    }

    /**
     * Adds an element to the top of the Stack
     * @param e the element to add to the top of the Stack
     * @return true if the add was successful, false if not
     */
    @Override
    public boolean push(Object e) throws StackOverflowException {

        if (isFull())
            throw new StackOverflowException();

        stackArray[topIndex + 1] = (T) e;
        topIndex += 1;
        return true;

    }

    /**
     * Returns the elements of the Stack in a string from bottom to top, the beginning
     * of the String is the bottom of the stack
     * @return an string which represent the Objects in the Stack from bottom to top
     */
    @Override
    public String toString(String delimiter) {
        String string = "";
        for (int i = 0; i <= topIndex; i++) {
            if (i != topIndex)
                string += stackArray[i].toString() + delimiter;
            else
                string += stackArray[i].toString();
        }
        return string;
    }

    /**
     * Returns the string representation of the elements in the Stack, the beginning of the
     * string is the bottom of the stack
     * Place the delimiter between all elements of the Stack
     * @return string representation of the Stack from bottom to top with elements
     * separated with the delimiter
     */
    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i <= topIndex; i++) {
            string += stackArray[i].toString();
        }
        return string;
    }


    /**
     * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
     * is the first bottom element in the Stack
     * @param list elements to be added to the Queue
     */
    public void fill(ArrayList list) {

        ArrayList<T> cloneList = new ArrayList<>();
        for (Object e: list) {
            cloneList.add((T) e);
        }

        for (int i=0; i < cloneList.size(); i++){
            push(cloneList.get(i));
        }
    }
}
