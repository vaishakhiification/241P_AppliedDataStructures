public class LinkedList extends SetImplementation {

    static Node head;
    static Node tail;
    static int size = 0;

    static class Node {

        String data;
        Node next;

        Node(String d) {
            this.data = d;
            next = null;
        }

        Node() {
            this.data = null;
            next = null;
        }
    }

    @Override
    public boolean add(String word) {
        if (!contains(word)) {
            Node node = new Node(word);
            if (size == 0) {
                tail = node;
                head = node;
            } else {
                tail.next = node;
                node.next = null;
                tail = node;
            }
            size++;
        }
        return true;
    }

    @Override
    public boolean contains(String word) {
        Node node = head;
        while (node != null) {
            if (node.data.equals(word)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

}
