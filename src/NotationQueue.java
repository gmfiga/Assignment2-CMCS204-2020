import exceptions.QueueOverflowException;
import exceptions.QueueUnderflowException;

import java.util.ArrayList;

/** Class for a Queue
 *
 * @author Gabriel Martins Figueiredo
 *
 * @param <T> data type
 */
public class NotationQueue<T> implements QueueInterface {

    private T[] queueArray;
    private int front;
    private int rear;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 50;

    /**
     * constructor takes an int as the size of the queue
     * @param i - size of the queue
     */
    public NotationQueue(int i) {
        T[] tempStack = (T[]) new Object[i];
        queueArray = tempStack;
        front = 0;
        rear = 0;
        capacity = i;
    }

    /**
     * default constructor - uses a default as the size of the queue
     */
    public NotationQueue() {
        T[] tempStack = (T[]) new Object[DEFAULT_CAPACITY];
        queueArray = tempStack;
        front = 0;
        rear = 0;
        capacity = DEFAULT_CAPACITY;
    }

    /**
     * takes an ArrayList as a parameter, and fills the Queue with the
     * elements of the ArrayList, First element in the ArrayList is the first element in the Queue
     * @param arrayList - list of items
     */
    public NotationQueue(ArrayList<T> arrayList) {
        T[] tempStack = (T[]) new Object[DEFAULT_CAPACITY];
        queueArray = tempStack;
        front = 0;
        rear = 0;
        capacity = DEFAULT_CAPACITY;
        fill(arrayList);
    }


    /**
     * Determines if Queue is empty
     * @return true if Queue is empty, false if not
     */
    @Override
    public boolean isEmpty() {
        if (rear == 0)
            return true;
        return false;
    }

    /**
     * Determines of the Queue is empty
     * @return
     */
    @Override
    public boolean isFull() {
        if (rear == capacity)
            return true;
        return false;
    }

    /**
     * Deletes and returns the element at the front of the Queue
     * @return the element at the front of the Queue
     */
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

    /**
     * Number of elements in the Queue
     * @return the number of elements in the Queue
     */
    @Override
    public int size() {
        return rear;
    }

    /**
     * Adds an element to the end of the Queue
     * @param e the element to add to the end of the Queue
     * @return true if the add was successful, false if not
     */
    @Override
    public boolean enqueue(Object e) throws QueueOverflowException {

        if (isFull())
            throw new QueueOverflowException();

        queueArray[rear] = (T) e;
        rear++;

        return true;
    }

    /**
     * Returns the string representation of the elements in the Queue,
     * the beginning of the string is the front of the queue
     * @return string representation of the Queue with elements
     */
    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < rear; i++) {
            string += queueArray[i].toString();
        }
        return string;
    }

    /**
     * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
     * Place the delimiter between all elements of the Queue
     * @return string representation of the Queue with elements separated with the delimiter
     */
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

    /**
     * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
     * is the first element in the Queue
     * @param list elements to be added to the Queue
     */
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
