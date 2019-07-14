import java.util.NoSuchElementException;

public class MyArrayQueue<Item> {
    private int size = 0;
    private Object[] queue = new Object[1];
    private int start = 0;//left
    private int end = 0;//right


    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = queue[(i + start) % queue.length]; //x % size = [0..size - 1]
        }
        start = 0;
        end = size;
        queue = tmp;
    }

    public void addRight(Item item) {
        if (size == queue.length) {
            resize(queue.length * 2);
        }
        size++;
        Object[] queueTmp = new Object[size];
        System.arraycopy(queue, 0, queueTmp, 0,size);

        queueTmp[size-1] = item;

        System.arraycopy(queueTmp, 0, queue, 0,size);
        //if (end == queue.length) { end = 0; }
        end %= queue.length;
    }

    public void addLeft(Item item) {
        if (size == queue.length) {
            resize(queue.length * 2);
        }
        Object[] queueTmp = new Object[size+1];
        System.arraycopy(queue, 0, queueTmp, 1,size);
        queueTmp[0] = item;
        size++;
        System.arraycopy(queueTmp, 0, queue, 0,size);
    }

    public Item removeLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        Item item = (Item) queue[start];
        queue[start] = null;
        size--;
        start = (start + 1) % queue.length;
        if (size == queue.length / 4 && size > 0) {
            resize(queue.length / 2);
        }
        return item;
    }
    public Item removeRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        Item item = (Item) queue[end];
        queue[end] = null;
        size--;
        end = (end - 1) % queue.length;
        if (size == queue.length / 4 && size > 0) {
            resize(queue.length / 2);
        }
        return item;
    }

    public Item peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return (Item) queue[start];
    }
    public Item peekLast(){
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return (Item) queue[end-1];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append((queue[(i + start) % queue.length] + ", "));
        }
        return s.toString();
    }
}
