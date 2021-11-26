package tree;

import utils.TextUtils;

import java.util.Stack;

/**
 *       tree with array index
 *       ----
 *         j(0)    <-- root
 *       /   \
 *      f(1)  k(2)
 *    /  \     \
 *   a(3) h(4)  z(6)    <-- leaves
 *
 *   tree array : [j, f, k, a, h, null, z], total nodes = 2^treeHeight - 1 = 2^3-1 = 7
 */
public class BinaryTreeArrayImpl {

    private final int root = 0;
    private final String[] treeArray;

    public BinaryTreeArrayImpl(int arraySize) {
        treeArray = new String[arraySize];
    }

    public BinaryTreeArrayImpl(String rootValue, int arraySize) {
        treeArray = new String[arraySize];
        treeArray[root] = rootValue;
    }

    public int insertRoot(String value) {
        treeArray[root] = value;
        return root;
    }

    public int insertLeft(String value, int parent) {
        int left = (parent * 2) + 1;
        if (treeArray[parent] == null) {
            System.out.printf("Can't set child at %d, no parent found\n", left);
            throw new RuntimeException("no parent found");
        } else {
            treeArray[left] = value;
        }
        return left;
    }

    public int insertRight(String value, int parent) {
        int right = (parent * 2) + 2;
        if (treeArray[parent] == null) {
            System.out.printf("Can't set child at %d, no parent found\n", right);
            throw new RuntimeException("no parent found");
        } else {
            treeArray[right] = value;
        }
        return right;
    }

    public String[] getTree() {
        return treeArray;
    }

    // Iterative Inorder Traversal
    public static void inorderTraversal(String[] tree) {
        if (tree == null) {
            return;
        }

        Stack<Integer> s = new Stack<>();

        // start from the root node (set current node to the root node)
        int current = 0; //root index

        // if the current node is null and the stack is also empty, we are done
        while (!s.empty() || (current < tree.length && tree[current] != null)) {
            // if the current node exists, push it into the stack (defer it)
            // and move to its left child
            if (current < tree.length && tree[current] != null) {
                s.push(current);
                current = (current * 2) + 1;
            } else {
                // otherwise, if the current node is null, pop an element from
                // the stack, print it, and finally set the current node to its
                // right child
                current = s.pop();
                System.out.print(tree[current] + " ");
                current = (current * 2) + 2;
            }
        }
    }

    // Iterative Preorder Traversal
    public static void preorderTraversal(String[] tree) {
        if (tree == null) {
            return;
        }

        // Create an empty stack and push root to it
        Stack<Integer> s = new Stack<>();
        int current = 0; //root index
        s.push(current);

        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first */

        // loop till stack is empty
        while (!s.empty()) {

            // Pop the top item from stack and print it
            current = s.pop();
            System.out.print(tree[current] + " ");

            // Push right and left children of the popped node into the stack
            int right = (current * 2) + 2;
            if (right < tree.length && tree[right] != null) {
                s.push(right);
            }

            int left = (current * 2) + 1;
            if (left < tree.length && tree[left] != null) {
                s.push(left);
            }
            // the right child must be pushed first so that the left child
            // is processed first (LIFO order)
        }
    }

    // Iterative
    public static void postorderTraversal(String[] tree) {
        if (tree == null) {
            return;
        }

        // create an empty stack and push the root node
        Stack<Integer> stack = new Stack<>();
        // create another stack to store postorder traversal
        Stack<Integer> out = new Stack<>();

        int current = 0; //root index
        stack.push(current);

        // loop till stack is empty
        while (!stack.empty()) {

            // pop a node from the stack and push the data into the output stack
            current = stack.pop();
            out.push(current);

            // push the left and right child of the popped node into the stack
            int left = (current * 2) + 1;
            if (left < tree.length && tree[left] != null) {
                stack.push(left);
            }

            int right = (current * 2) + 2;
            if (right < tree.length && tree[right] != null) {
                stack.push(right);
            }
        }

        // print postorder traversal
        while (!out.empty()) {
            System.out.print(tree[out.pop()] + " ");
        }

    }

    public static void main(String[] args) {
        BinaryTreeArrayImpl treeArrayImpl = new BinaryTreeArrayImpl(7);
        int root = treeArrayImpl.insertRoot("j");
        int node1 = treeArrayImpl.insertLeft("f", root);
        int node2 = treeArrayImpl.insertRight("k", root);
        int node3 = treeArrayImpl.insertLeft("a", node1);
        int node4 = treeArrayImpl.insertRight("h", node1);
        int node6 = treeArrayImpl.insertRight("z", node2);

        String[] treeArray = treeArrayImpl.getTree();

        System.out.print("tree array: ");
        for (String node : treeArray) {
            System.out.print((TextUtils.isEmpty(node) ? "null" : node) + " ");
        }

        System.out.println();

        System.out.print("tree inorder traversal: ");
        BinaryTreeArrayImpl.inorderTraversal(treeArray);

        System.out.println();

        System.out.print("tree preorder traversal: ");
        BinaryTreeArrayImpl.preorderTraversal(treeArray);

        System.out.println();

        System.out.print("tree postorder traversal: ");
        BinaryTreeArrayImpl.postorderTraversal(treeArray);
    }

}
