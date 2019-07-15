public class MyLinkedQueue<Item> {
    private MyLinkedList<Item> queue = new MyLinkedList<>();

    public int size() { return queue.size(); }

    public boolean isEmpty() {return queue.isEmpty(); }

    public void enqueue(Item item) { queue.addLast(item); }

    public Item dequeue() { return queue.removeFirst(); }

    public Item get() { return queue.get(0);}

    public String toString() { return queue.toString(); }
}
