import exceptions.StackOverflowException;
import exceptions.StackUnderflowException;

import java.util.ArrayList;

public class NotationStack<T> implements StackInterface {

    private T[] stackArray;
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 50;

    public NotationStack(int initialCapacity) {
        T[] tempStack = (T[]) new Object[initialCapacity];
        stackArray = tempStack;
        topIndex = -1;
    }

    public NotationStack() {
        T[] tempStack = (T[]) new Object[DEFAULT_CAPACITY];
        stackArray = tempStack;
        topIndex = -1;
    }

    public NotationStack(ArrayList<T> arrayList) {
        T[] tempStack = (T[]) new Object[DEFAULT_CAPACITY];
        stackArray = tempStack;
        topIndex = -1;
        fill(arrayList);
    }

    @Override
    public boolean isEmpty() {
        if (topIndex == -1)
            return true;
        return false;
    }

    @Override
    public boolean isFull() {
        if (stackArray.length - 1 == topIndex)
            return true;
        return false;
    }

    @Override
    public T pop() throws StackUnderflowException {

        if (isEmpty())
            throw new StackUnderflowException();

        T top = stackArray[topIndex];
        stackArray[topIndex] = null;
        topIndex -= 1;
        return top;
    }

    @Override
    public T top() throws StackUnderflowException {
        if (isEmpty())
            throw new StackUnderflowException();
        return stackArray[topIndex];
    }

    @Override
    public int size() {
        return topIndex + 1;
    }

    @Override
    public boolean push(Object e) throws StackOverflowException {

        if (isFull())
            throw new StackOverflowException();

        stackArray[topIndex + 1] = (T) e;
        topIndex += 1;
        return true;

    }

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

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i <= topIndex; i++) {
            string += stackArray[i].toString();
        }
        return string;
    }


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
