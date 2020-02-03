//Problem Statement:
//Write a program to reverse the direction of a given singly-linked list.
//In other words, after the reversal all pointers should now point backwards.
//Your algorithm should take linear time

public class Practice_M3_2 {
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

        System.out.println("List is as follows: ");
        displayList();

        Node node = head;
        Node next = node.next;
        Node nnext = next.next;
        node.next = null;
        while (node != null) {
            if (next != null) {
                nnext = next.next;
                next.next = node;
            } else {
                head = node;
            }
            node = next;
            next = nnext;
        }
        System.out.println("\nUpdated: ");
        displayList();
    }
}
