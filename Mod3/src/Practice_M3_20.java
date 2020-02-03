// Problem Statement:
// Write a function to find the middle node of a singly-linked list.

public class Practice_M3_20 {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            next = null;
        }

        Node() {
            this.data = 0;
            next = null;
        }
    }

    public static void insertNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
    }

    public static void displayList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        insertNode(1);
        insertNode(2);
        insertNode(3);
        insertNode(4);
        insertNode(5);

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle Element: " + slow.data);
    }
}
