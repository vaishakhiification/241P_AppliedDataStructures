public class HashTable extends SetImplementation {

    static int n = 0;
    static int size = 0;
    static Node[] table;

    static class Node {

        String data;
        Integer key;
        Node next;

        Node(String d) {
            this.data = d;
        }

        Node() {
            this.data = null;
        }
    }

    private static int getBucketIndex(String key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % n);
    }

    @Override
    public boolean add(String word) {
        if (!contains(word)) {
            int key = getBucketIndex(word);
            Node node = new Node(word);
            if (table[key] != null) {
                Node next = table[key];
                while (next.next != null) {
                    next = next.next;
                }
                next.next = node;
            } else {
                table[key] = node;
            }
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(String word) {
        int key = getBucketIndex(word);
        Node node = table[key];
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

    public static void setSize(int n) {
        size = n;
    }

    public HashTable(int n) {
        this.n = n;
        table = new Node[n];
    }

}
