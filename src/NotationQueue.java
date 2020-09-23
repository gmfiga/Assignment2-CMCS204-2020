import exceptions.QueueOverflowException;
import exceptions.QueueUnderflowException;

import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface {

    private T[] queueArray;
    private int front;
    private int rear;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 50;

    public NotationQueue(int i) {
        T[] tempStack = (T[]) new Object[i];
        queueArray = tempStack;
        front = 0;
        rear = 0;
        capacity = i;
    }

    public NotationQueue() {
        T[] tempStack = (T[]) new Object[DEFAULT_CAPACITY];
        queueArray = tempStack;
        front = 0;
        rear = 0;
        capacity = DEFAULT_CAPACITY;
    }


    @Override
    public boolean isEmpty() {
        if (rear == 0)
            return true;
        return false;
    }

    @Override
    public boolean isFull() {
        if (rear == capacity)
            return true;
        return false;
    }

    @Override
    public Object dequeue() throws QueueUnderflowException {

        if (isEmpty())
            throw new QueueUnderflowException();

        T frontElement = queueArray[front];

        for (int i = 0; i +1< rear; i++){
            queueArray[i] = queueArray[i+1];
        }

        queueArray[rear] = null;
        rear--;

        return frontElement;
    }

    @Override
    public int size() {
        return rear;
    }

    @Override
    public boolean enqueue(Object e) throws QueueOverflowException {

        if (isFull())
            throw new QueueOverflowException();

        queueArray[rear] = (T) e;
        rear++;

        return true;
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < rear; i++) {
            string += queueArray[i].toString();
        }
        return string;
    }

    @Override
    public String toString(String delimiter) {
        String string = "";
        for (int i = 0; i < rear; i++) {
            if (i != rear-1)
                string += queueArray[i].toString() + delimiter;
            else
                string += queueArray[i].toString();
        }
        return string;
    }

    @Override
    public void fill(ArrayList list) {
        ArrayList<T> cloneList = new ArrayList<>();
        for (Object e: list) {
            cloneList.add((T) e);
        }

        for (int i=0; i < cloneList.size(); i++){
            enqueue(cloneList.get(i));
        }
    }
}
