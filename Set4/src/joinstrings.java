import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class joinstrings {

    public static class LinkedList {

        Node head;
        Node tail;

        public static class Node {

            String data;
            Node next;

            Node(String s) {
                data = s;
                next = null;
            }
        }

        public Node getHead() {
            return head;
        }

        public Node getTail() {
            return tail;
        }

        public void addNode(Node node) {
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            tail.next = node;
            tail = node;
        }
        public void addList(LinkedList l) {
            this.tail.next = l.head;
            this.tail = l.tail;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader f = new FastReader();
        int n = f.nextInt();

        LinkedList[] l = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            LinkedList r = new LinkedList();
            r.addNode(new LinkedList.Node(f.nextLine()));
            l[i] = r;
        }
        int a = 0; int b;
        for (int i = 0; i < n - 1; i++) {
            a = f.nextInt() - 1;
            b = f.nextInt() - 1;
            l[a].addList(l[b]);
        }
        PrintWriter out = new PrintWriter(System.out);
        LinkedList.Node node = l[a].head;
        while (node != null) {
            out.print(node.data);
            node = node.next;
        }
        out.close();
    }
}
