public class BinaryTree extends SetImplementation {

    static Node root = null;
    static int size = 0;

    static class Node {

        String data;
        Node left;
        Node right;

        Node(String d) {
            this.data = d;
        }

        Node() {
            this.data = null;
            this.left = null;
            this.right = null;
        }
    }

    @Override
    public boolean add(String word) {
        if (!contains(word)) {
            insertNode(root, word);
            size++;
            return true;
        }
        return false;
    }

    public Node insertNode(Node node, String word) {
        if (root == null) {
            root = new Node(word);
            return node;
        } else if (node == null) {
            return new Node(word);
        } else if (word.compareTo(node.data) <= 0) {
            node.left = insertNode(node.left, word);
        } else if (word.compareTo(node.data) > 0) {
            node.right = insertNode(node.right, word);
        }
        return node;
    }


    @Override
    public boolean contains(String word) {
        return containsWord(root, word);
    }


    private boolean containsWord(Node node, String word) {
        if (node == null) {
            return false;
        } else if (node.data.equals(word)) {
            return true;
        } else if (word.compareTo(node.data) < 0) {
            return (containsWord(node.left, word));
        } else {
            return (containsWord(node.right, word));
        }
    }

    @Override
    public int size() {
        return size;
    }

}