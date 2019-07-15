public class Program {
    public static void main(String[] args) {
        MyLinkedList<Character> linkedList = new MyLinkedList<>();
        linkedList.addLast('a');
        linkedList.addLast('b');
        linkedList.addLast('c');
        System.out.println(linkedList.size());
        System.out.println(linkedList);
        System.out.println(linkedList.get(1));
        linkedList.set(1, 'd');
        System.out.println(linkedList.get(1));
        linkedList.addFirst('e');
        linkedList.addLast('f');
        linkedList.add(2, 'g');
        System.out.println(linkedList);
        linkedList.removeLast();
        linkedList.removeFirst();
        System.out.println(linkedList);
        System.out.println(linkedList.indexOf('z'));
        System.out.println(linkedList.size());
        linkedList.remove('c');
        //System.out.println(linkedList);
        for (Character c:
             linkedList) {
            System.out.print(c + ", ");
        }

        MyLinkedQueue<Character> myLinkedQueue = new MyLinkedQueue<>();
        System.out.println("\n_______ Queue: ");
        myLinkedQueue.enqueue('a');
        myLinkedQueue.enqueue('b');
        myLinkedQueue.enqueue('c');
        System.out.println(myLinkedQueue.size());
        System.out.println(myLinkedQueue.toString());
        myLinkedQueue.dequeue();
        System.out.println(myLinkedQueue.toString());
        System.out.println(myLinkedQueue.get());


        MyLinkedStack<Character> stack = new MyLinkedStack<>();
        stack.add('c');
        stack.add('a');
        stack.add('z');
        System.out.println("\n_______ Stack: ");
        System.out.println("Stack size: " + stack.size());
        System.out.println(stack.toString());
        System.out.println(stack.get());
        stack.remove();
        System.out.println(stack.toString());
    }
}
