public class Program {
    public static void main(String[] args) {
        /*MyArrayStack<Character> stack = new MyArrayStack<>();
        stack.push('a');
        stack.push('c');
        stack.push('d');
        stack.push('x');
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);*/

        //(a + 4) * [(b - 7) / {a - 5 * (c + 8)}]
        //
        //(a + 4) * {(b - 7) / {a - 5 * (c + 8)}]
        //a + 4) * [(b - 7) / {a - 5 * (c + 8)}]
        //(a + 4) * ([(b - 7) / {a - 5 * (c + 8)}]
        /*Expression expr = new Expression("(a + 4) * ([(b - 7) / {a - 5 * (c + 8)}]");
        System.out.println(expr.checkBrackets());*/

        MyArrayQueue<Character> queue = new MyArrayQueue<>();
        queue.addLeft('a');
        queue.addLeft('b');
        queue.addLeft('c');
        queue.addLeft('d');
        queue.addRight('e');
        queue.peekLast();
        System.out.println(queue.peekLast().toString());
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.peekFront());
        queue.removeRight();
        System.out.println(queue.peekLast());
        queue.removeRight();
        queue.removeLeft();
        System.out.println(" " + queue);
        //queue.removeRight();
        //queue.removeRight();
        System.out.println(queue.isEmpty());
        queue.addLeft('f');
        queue.addRight('g');
        queue.addLeft('h');
        System.out.println(queue);
    }
}
