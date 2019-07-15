public class MyLinkedStack<Item> {
    private MyLinkedList<Item> queue = new MyLinkedList<>();

    public int size() { return queue.size(); }

    public boolean isEmpty() {return queue.isEmpty(); }

    public void add(Item item) { queue.addLast(item); }

    public void remove() { queue.removeLast(); }

    public Item get() { return queue.getLast(); }

    public String toString() { return queue.toString(); }

}
