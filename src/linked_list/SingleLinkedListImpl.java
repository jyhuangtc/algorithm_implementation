package linked_list;

public class SingleLinkedListImpl {

    private Node head;

    public SingleLinkedListImpl() {
        head = null;
    }

    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.item + " ");
            temp = temp.next;
        }
    }

    public void insertAtBeginning(int item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int item) {
        Node newNode = new Node(item);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void insertAfter(Node prevNode, int item) {
        if (prevNode == null) {
            System.out.println("The previous node can not be null.");
            return;
        }
        Node newNode = new Node(item);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public void insertAt(int position, int item) {
        Node newNode = new Node(item);

        if (head == null) {
            head = newNode;
            return;
        }

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        int count = 0;
        while (temp.next != null && count < position-1) {  // position < 2 == without going to next node
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteFromBeginning() {
        head = head.next;
    }

    public void deleteFromEnd() {
        if (head == null) {
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deleteFrom(int position) {
        if (head == null) {
            return;
        }

        if (position == 0) {
            head = head.next;
            return;
        }

        Node temp = head;
        int count = 0;
        // Find the key to be deleted
        while (temp.next != null  && temp.next.next != null && count < position-1) { // position < 2 == without going to next node
            temp = temp.next;
            count++;
        }
        // If the key is not present
        if (temp.next == null || temp.next.next == null) {
            return;
        }
        temp.next = temp.next.next;
    }

    public static class Node {
        int item;
        Node next;

        public Node(int item) {
            this.item = item;
            next = null;
        }
    }

    public static void main(String[] args) {
        SingleLinkedListImpl linkedList = new SingleLinkedListImpl();

        linkedList.insertAtEnd(1);
        linkedList.insertAtBeginning(2);
        linkedList.insertAtBeginning(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAfter(linkedList.head.next, 5);
        linkedList.insertAt(3, 6);

        System.out.println("Linked list: ");
        linkedList.traverse();

        System.out.println("\nAfter deleting elements: ");
        linkedList.deleteFrom(3);
        linkedList.deleteFromBeginning();
        linkedList.deleteFromEnd();
        linkedList.traverse();

        System.out.println();
    }
}
