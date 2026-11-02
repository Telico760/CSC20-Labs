
/*
 * Brian Bracamontes
 * CSC 20 - Tree Traversal
 * Java Swing GUI Version
 *
 * Features:
 * 1. Displays a binary search tree graphically.
 * 2. Allows users to insert integer keys.
 * 3. Performs in-order traversal (LNR).
 * 4. Performs pre-order traversal (NLR).
 * 5. Performs post-order traversal (LRN).
 * 6. Allows users to clear or reset the tree.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TreeTraversalGUI extends JFrame {

    // STEP 1: Define a node in the binary search tree.
    private static class Node {

        int key;
        Node left, right;

        // Initialize the node with the provided integer.
        Node(int key) {
            this.key = key;
        }
    }

    // STEP 2: Declare the tree root and GUI components.
    private Node root;

    // Custom JPanel used to draw the binary tree.
    private final TreePanel treePanel = new TreePanel();

    // Text field used to enter new integer keys.
    private final JTextField inputField = new JTextField(8);

    // Text area used to display traversal results.
    private final JTextArea output = new JTextArea(5, 35);


    // STEP 3: Construct the graphical user interface.
    public TreeTraversalGUI() {

        // Set the window title.
        super("Binary Search Tree Traversal");

        // Close the program when the window is closed.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Divide the window into separate regions.
        setLayout(new BorderLayout(8, 8));

        // Create a panel containing the controls.
        JPanel controls = new JPanel(
            new FlowLayout(FlowLayout.CENTER)
        );

        // Create the buttons used by the application.
        JButton insertButton = new JButton("Insert");
        JButton inOrderButton = new JButton("In-order");
        JButton preOrderButton = new JButton("Pre-order");
        JButton postOrderButton = new JButton("Post-order");
        JButton clearButton = new JButton("Clear Tree");
        JButton resetButton = new JButton("Reset Example");

        // Add input controls to the control panel.
        controls.add(new JLabel("Integer key:"));
        controls.add(inputField);
        controls.add(insertButton);

        // Add the traversal buttons.
        controls.add(inOrderButton);
        controls.add(preOrderButton);
        controls.add(postOrderButton);

        // Add the clear and reset buttons.
        controls.add(clearButton);
        controls.add(resetButton);

        // Place the controls at the top of the window.
        add(controls, BorderLayout.NORTH);

        // Place the tree drawing panel in the center.
        add(new JScrollPane(treePanel), BorderLayout.CENTER);

        // Configure the traversal output area.
        output.setEditable(false);

        output.setFont(
            new Font(Font.MONOSPACED, Font.PLAIN, 14)
        );

        // Place the output area at the bottom.
        add(new JScrollPane(output), BorderLayout.SOUTH);


        // STEP 4: Connect each button to its action.

        // Insert a new value when the user clicks Insert.
        insertButton.addActionListener(
            event -> insertFromInput()
        );

        // Also allow insertion by pressing Enter.
        inputField.addActionListener(
            event -> insertFromInput()
        );

        // Display the selected traversal order.
        inOrderButton.addActionListener(
            event -> showTraversal("In-order")
        );

        preOrderButton.addActionListener(
            event -> showTraversal("Pre-order")
        );

        postOrderButton.addActionListener(
            event -> showTraversal("Post-order")
        );

        // Remove all nodes from the current tree.
        clearButton.addActionListener(event -> {

            root = null;

            output.setText(
                "Tree cleared. Enter a number to insert a key."
            );

            // Refresh the visual representation.
            treePanel.repaint();
        });

        // Restore the professor's sample tree.
        resetButton.addActionListener(
            event -> resetExample()
        );

        // Load the example data when the application starts.
        resetExample();

        // Set the window size and center it.
        setSize(1050, 650);
        setLocationRelativeTo(null);
    }


    // STEP 5: Insert a key using binary search tree rules.
    private Node insertRec(Node current, int key) {

        // Create a new node when an empty position is found.
        if (current == null) {
            return new Node(key);
        }

        // Smaller values belong on the left.
        if (key < current.key) {

            current.left = insertRec(current.left, key);

        // Larger values belong on the right.
        } else if (key > current.key) {

            current.right = insertRec(current.right, key);
        }

        // Duplicate values are ignored.
        return current;
    }


    // STEP 6: Read and insert the user's input.
    private void insertFromInput() {

        try {

            // Convert the entered text into an integer.
            int key = Integer.parseInt(
                inputField.getText().trim()
            );

            // Insert the key into the binary search tree.
            root = insertRec(root, key);

            // Display a confirmation message.
            output.setText(
                "Inserted or already present: " + key +
                "\nSelect a traversal button to see the visiting order."
            );

            // Redraw the tree after insertion.
            treePanel.repaint();

            // Clear the input field for another integer.
            inputField.setText("");

        } catch (NumberFormatException ex) {

            // Handle invalid integer input without crashing.
            output.setText(
                "Invalid input. Enter an integer such as 5 or -2."
            );
        }

        // Return keyboard focus to the input field.
        inputField.requestFocusInWindow();
    }


    // STEP 7: Restore the original example tree.
    private void resetExample() {

        // Remove the previous tree.
        root = null;

        // These are the professor's original sample keys.
        int[] keys = {8, 3, 10, 1, 6};

        // Insert each number in order.
        for (int key : keys) {
            root = insertRec(root, key);
        }

        // Explain which data was loaded.
        output.setText(
            "Example keys inserted: 8, 3, 10, 1, 6\n" +
            "Choose In-order, Pre-order, or Post-order."
        );

        // Update the displayed tree.
        treePanel.repaint();
    }


    // STEP 8: Implement in-order traversal (LNR).
    private void inOrder(Node current, StringBuilder result) {

        if (current != null) {

            // Visit the left subtree first.
            inOrder(current.left, result);

            // Append the current node's key.
            result.append(current.key).append(' ');

            // Visit the right subtree last.
            inOrder(current.right, result);
        }
    }


    // STEP 9: Implement pre-order traversal (NLR).
    private void preOrder(Node current, StringBuilder result) {

        if (current != null) {

            // Append the current node before its children.
            result.append(current.key).append(' ');

            // Visit the left subtree.
            preOrder(current.left, result);

            // Visit the right subtree.
            preOrder(current.right, result);
        }
    }


    // STEP 10: Implement post-order traversal (LRN).
    private void postOrder(Node current, StringBuilder result) {

        if (current != null) {

            // Visit the left subtree.
            postOrder(current.left, result);

            // Visit the right subtree.
            postOrder(current.right, result);

            // Append the current node after its children.
            result.append(current.key).append(' ');
        }
    }


    // STEP 11: Display the requested traversal.
    private void showTraversal(String kind) {

        // Store the visited nodes in a mutable String.
        StringBuilder result = new StringBuilder();

        // Select the correct traversal algorithm.
        switch (kind) {

            case "In-order":
                inOrder(root, result);
                break;

            case "Pre-order":
                preOrder(root, result);
                break;

            case "Post-order":
                postOrder(root, result);
                break;

            default:
                return;
        }

        // Display the traversal or an empty-tree message.
        output.setText(
            kind + " traversal:\n" +
            (root == null
                ? "(empty tree)"
                : result.toString().trim())
        );
    }


    // STEP 12: Create a custom JPanel to draw the tree.
    private class TreePanel extends JPanel {

        // Configure the drawing area.
        TreePanel() {

            setBackground(Color.WHITE);

            setPreferredSize(
                new Dimension(1000, 430)
            );
        }

        // Swing calls this method whenever the panel is redrawn.
        @Override
        protected void paintComponent(Graphics graphics) {

            // Clear the panel before redrawing its contents.
            super.paintComponent(graphics);

            // Use Graphics2D for improved rendering.
            Graphics2D g = (Graphics2D) graphics.create();

            // Enable antialiasing for smoother lines and circles.
            g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );

            // Display a message if the tree is empty.
            if (root == null) {

                g.setColor(Color.DARK_GRAY);

                g.drawString(
                    "Tree is empty. Enter a key and select Insert.",
                    20,
                    30
                );

            } else {

                // Begin drawing from the root at the top center.
                drawNode(
                    g,
                    root,
                    getWidth() / 2,
                    40,
                    getWidth() / 4
                );
            }

            // Release the temporary graphics context.
            g.dispose();
        }


        // STEP 13: Recursively draw nodes and connecting lines.
        private void drawNode(
            Graphics2D g,
            Node node,
            int x,
            int y,
            int offset
        ) {

            // Calculate spacing for the next tree level.
            int nextOffset = Math.max(24, offset / 2);
            int nextY = y + 75;

            // Draw the left child and its connecting line.
            if (node.left != null) {

                g.setColor(Color.GRAY);

                g.drawLine(
                    x, y,
                    x - offset, nextY
                );

                drawNode(
                    g,
                    node.left,
                    x - offset,
                    nextY,
                    nextOffset
                );
            }

            // Draw the right child and its connecting line.
            if (node.right != null) {

                g.setColor(Color.GRAY);

                g.drawLine(
                    x, y,
                    x + offset, nextY
                );

                drawNode(
                    g,
                    node.right,
                    x + offset,
                    nextY,
                    nextOffset
                );
            }

            // Draw a filled circle representing the node.
            g.setColor(new Color(15, 118, 110));

            g.fillOval(
                x - 22,
                y - 22,
                44,
                44
            );

            // Display the integer key in the node.
            g.setColor(Color.WHITE);

            String label = Integer.toString(node.key);

            // Center the text horizontally in the circle.
            int textWidth = g.getFontMetrics()
                             .stringWidth(label);

            g.drawString(
                label,
                x - textWidth / 2,
                y + 5
            );
        }
    }


    // STEP 14: Launch the graphical application.
    public static void main(String[] args) {

        // Create the GUI on Swing's Event Dispatch Thread.
        SwingUtilities.invokeLater(
            () -> new TreeTraversalGUI().setVisible(true)
        );
    }
}
