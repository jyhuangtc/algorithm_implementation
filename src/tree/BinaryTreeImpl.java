package tree;

import java.util.Stack;

public class BinaryTreeImpl {
    public Node root;

    public BinaryTreeImpl() {
        root = null;
    }

    public BinaryTreeImpl(int rootValue) {
        root = new Node(rootValue);
    }

    public Node insertLeft(int value, Node parent) {
        Node left = new Node(value);
        if (parent == null) {
            System.out.println("Can't set child, no parent found");
            throw new RuntimeException("no parent found");
        } else {
            parent.left = left;
        }
        return left;
    }

    public Node insertRight(int value, Node parent) {
        Node right = new Node(value);
        if (parent == null) {
            System.out.println("Can't set child, no parent found");
            throw new RuntimeException("no parent found");
        } else {
            parent.right = right;
        }
        return right;
    }


    // Traverse Inorder
    public void traverseInorder(Node node) {
        if (node == null) {
            return;
        }
        traverseInorder(node.left);
        System.out.print(" " + node.value);
        traverseInorder(node.right);
    }

    // Traverse Preorder
    public void traversePreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(" " + node.value);
        traversePreorder(node.left);
        traversePreorder(node.right);
    }

    // Traverse Postorder
    public void traversePostorder(Node node) {
        if (node == null) {
            return;
        }
        traversePostorder(node.left);
        traversePostorder(node.right);
        System.out.print(" " + node.value);
    }

    // Traverse Inorder Iteratively
    public void traverseInorderIteratively(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();

        Node current = node;

        while (!stack.empty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.print(current.value + " ");
                current = current.right;
            }
        }
    }

    // Traverse Preorder Iteratively
    public void traversePreorderIteratively(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();

        Node current = node;
        stack.push(current);

        while (!stack.empty()) {

            current = stack.pop();
            System.out.print(current.value + " ");

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    // Traverse Postorder Iteratively
    public void traversePostorderIteratively(Node node) {
        if (node == null) {
            return;
        }

        Node current = node;
        Stack<Node> stack = new Stack<>();
        stack.push(current);

        Stack<Node> output = new Stack<>();

        while (!stack.empty()) {
            current = stack.pop();
            output.push(current);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        while (!output.empty()) {
            System.out.print(output.pop().value + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTreeImpl tree = new BinaryTreeImpl();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);


        System.out.print("In order Traversal: ");
        tree.traverseInorder(tree.root);
        //tree.traverseInorderIteratively(tree.root);
        System.out.println();
        System.out.print("Pre order Traversal: ");
        tree.traversePreorder(tree.root);
        //tree.traversePreorderIteratively(tree.root);
        System.out.println();
        System.out.print("Post order Traversal: ");
        tree.traversePostorder(tree.root);
        //tree.traversePostorderIteratively(tree.root);
    }
}

class Node {
    int value;
    Node left, right = null;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}