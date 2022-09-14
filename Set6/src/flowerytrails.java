import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;



public class flowerytrails {
    public static void main(String[] args) throws IOException {
        FastReader f = new FastReader();
        int p = f.nextInt();
        int t = f.nextInt();
        Node[] nodes = new Node[p];
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        Node n = new Node(0);
        n.dist = 0;
        nodes[0] = n;
        pq.add(n);
        for (int i = 1; i < p; i++) {
            n = new Node(i);
            nodes[i] = n;
            pq.add(n);
        }
        ArrayList<Edge>[] edges = new ArrayList[p];
        ArrayList<Integer>[] prev = new ArrayList[p];
        for (int i = 0; i < p; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < t; i++) {
            int x = f.nextInt();
            int y = f.nextInt();
            int c = f.nextInt();
            edges[x].add(new Edge(nodes[y], c));
            edges[y].add(new Edge(nodes[x], c));
        }
        boolean[] visited = new boolean[p];
        while (true) {
            n = pq.poll();
            visited[n.num] = true;
            if (n.num == p -1){
                break;
            }
            for (Edge e: edges[n.num]) {
                if (!visited[e.dis.num]) {
                    int alt = n.dist + e.cost;
                    pq.remove(e.dis);
                    if (alt < e.dis.dist) {
                        e.dis.dist = alt;
                        ArrayList<Integer> r = new ArrayList<>(1);
                        r.add(n.num);
                        prev[e.dis.num] = r;
                    } else if (alt == e.dis.dist) {
                        prev[e.dis.num].add(n.num);
                    }
                    pq.add(e.dis);
                }
            }
        }
        boolean[] q = new boolean[p];
        System.out.println(2 * com(p -1, prev, nodes, q));
    }
    public static int com(int c, ArrayList<Integer>[] prev, Node[] nodes, boolean[] q) {
        if (c == 0) {
            return 0;
        }
        if (!q[c]) {
            int k = 0;
            q[c] = true;
            for (int n : prev[c]) {
                k += nodes[c].dist - nodes[n].dist;
                k += com(n, prev, nodes, q);
            }
            return k;
        }
        return 0;
    }
}
