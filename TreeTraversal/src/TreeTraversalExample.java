
/*
 * Brian Bracamontes
 * CSC 20 - Tree Traversal
 * Console Version
 *
 * Demonstrates binary search tree insertion
 * and three recursive depth-first traversals.
 */

public class TreeTraversalExample {

    // Each node stores one key and references
    // to its left and right child nodes.
    static class Node {

        int key;
        Node left, right;

        // Create a new node with the specified key.
        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    // The root is null until the first value is inserted.
    Node root;

    // Insert a new integer into the binary search tree.
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursively find the correct position for a key.
    private Node insertRec(Node current, int key) {

        // Create a new node at an empty location.
        if (current == null) {
            return new Node(key);
        }

        // Smaller keys belong in the left subtree.
        if (key < current.key) {
            current.left = insertRec(current.left, key);

        // Larger keys belong in the right subtree.
        } else if (key > current.key) {
            current.right = insertRec(current.right, key);
        }

        // Equal keys are ignored.
        // Return the current subtree root.
        return current;
    }

    // In-order traversal (LNR):
    // Left subtree -> Node -> Right subtree.
    public void inOrder(Node current) {

        if (current != null) {

            // Visit the left subtree.
            inOrder(current.left);

            // Visit the current node.
            System.out.print(current.key + " ");

            // Visit the right subtree.
            inOrder(current.right);
        }
    }

    // Pre-order traversal (NLR):
    // Node -> Left subtree -> Right subtree.
    public void preOrder(Node current) {

        if (current != null) {

            // Visit the current node first.
            System.out.print(current.key + " ");

            // Visit the left subtree.
            preOrder(current.left);

            // Visit the right subtree.
            preOrder(current.right);
        }
    }

    // Post-order traversal (LRN):
    // Left subtree -> Right subtree -> Node.
    public void postOrder(Node current) {

        if (current != null) {

            // Visit the left subtree.
            postOrder(current.left);

            // Visit the right subtree.
            postOrder(current.right);

            // Visit the current node last.
            System.out.print(current.key + " ");
        }
    }

    public static void main(String[] args) {

        // Create an empty binary search tree.
        TreeTraversalExample tree = new TreeTraversalExample();

        // Insert the example keys in this exact order.
        // The insertion order determines the tree's shape.
        int[] keys = {8, 3, 10, 1, 6};

        for (int key : keys) {
            tree.insert(key);
        }

        // Display in-order traversal.
        System.out.println("In-Order Traversal:");
        tree.inOrder(tree.root);
        System.out.println("\n");

        // Display pre-order traversal.
        System.out.println("Pre-Order Traversal:");
        tree.preOrder(tree.root);
        System.out.println("\n");

        // Display post-order traversal.
        System.out.println("Post-Order Traversal:");
        tree.postOrder(tree.root);
        System.out.println();
    }
}
