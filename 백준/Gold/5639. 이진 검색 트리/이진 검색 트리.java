import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        Node root;

        public BinaryTree(int rootValue) {
            root = new Node(rootValue);
        }

        public void postOrder(Node node) { // 후위 순위
            if (node == null) {
                return;
            }
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        BinaryTree tree = null;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int value = Integer.parseInt(line);

            if (tree == null) {
                tree = new BinaryTree(value);
            } else {
                Node node = tree.root;
                while (true) {
                    if (value < node.value) {
                        if (node.left == null) {
                            node.left = new Node(value);
                            break;
                        } else {
                            node = node.left;
                        }
                    } else {
                        if (node.right == null) {
                            node.right = new Node(value);
                            break;
                        } else {
                            node = node.right;
                        }
                    }
                }
            }
        }

        tree.postOrder(tree.root);
    }
}