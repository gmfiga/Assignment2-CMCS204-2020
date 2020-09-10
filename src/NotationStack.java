import exceptions.StackOverflowException;
import exceptions.StackUnderflowException;

import java.util.ArrayList;

public class NotationStack<T> implements StackInterface{
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Object pop() throws StackUnderflowException {
        return null;
    }

    @Override
    public Object top() throws StackUnderflowException {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean push(Object e) throws StackOverflowException {
        return false;
    }

    @Override
    public String toString(String delimiter) {
        return null;
    }

    @Override
    public void fill(ArrayList list) {

    }
}
