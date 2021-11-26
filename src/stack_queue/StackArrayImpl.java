package stack_queue;

public class StackArrayImpl {

    private int[] stack;
    private int capacity = 0;
    private int top = -1;

    public StackArrayImpl(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
    }

    private void doubleCapacity() {
        int[] newStack = new int[capacity * 2];
        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        capacity = capacity * 2;
        stack = newStack;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            doubleCapacity();
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is empty.");
            return -1;
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("stack is empty.");
            return -1;
        }
        return stack[top];
    }

    public int getSize() {
        return top + 1;
    }

    public static void main(String[] args) {
        StackArrayImpl stackArrayImpl = new StackArrayImpl(3);

        stackArrayImpl.pop();
        stackArrayImpl.push(3);
        stackArrayImpl.push(4);
        stackArrayImpl.push(5);
        stackArrayImpl.push(6);
        stackArrayImpl.pop();
        stackArrayImpl.pop();
        stackArrayImpl.push(7);
        stackArrayImpl.pop();
        stackArrayImpl.push(8);

        int size = stackArrayImpl.getSize();
        for (int i = 0; i < size; i++) {
            System.out.print(stackArrayImpl.pop() + " ");
        }
    }
}
