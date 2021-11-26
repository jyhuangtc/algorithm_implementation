package stack_queue;

public class StackListImpl {
    private StackNode head;
    private int size;

    public StackListImpl() {
        head = null;
        size = 0;
    }

    public void push(int value) {
        StackNode next = new StackNode(value);
        if (!isEmpty()) {
            next.next = head;
        }
        head = next;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is empty.");
            return -1;
        }
        StackNode pop = head;
        head = head.next;
        size--;
        return pop.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("stack is empty.");
            return -1;
        }
        return head.value;
    }

    public int getSize() {
        return size;
    }

    public static class StackNode {
        public int value;
        public StackNode next;

        public StackNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        StackListImpl stackListImpl = new StackListImpl();

        stackListImpl.pop();
        stackListImpl.push(3);
        stackListImpl.push(4);
        stackListImpl.push(5);
        stackListImpl.push(6);
        stackListImpl.pop();
        stackListImpl.pop();
        stackListImpl.push(7);
        stackListImpl.pop();
        stackListImpl.push(8);

        int size = stackListImpl.getSize();
        for (int i = 0; i < size; i++) {
            System.out.print(stackListImpl.pop() + " ");
        }
    }
}
