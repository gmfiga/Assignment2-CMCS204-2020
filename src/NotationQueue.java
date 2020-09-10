import exceptions.QueueOverflowException;
import exceptions.QueueUnderflowException;

import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface{
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Object dequeue() throws QueueUnderflowException {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean enqueue(Object e) throws QueueOverflowException {
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
