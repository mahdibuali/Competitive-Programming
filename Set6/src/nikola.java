import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class NodeComparator implements Comparator<Node> {

    public int compare(Node e1, Node e2) {
        if (e1.dist > e2.dist)
            return 1;
        else if (e1.dist < e2.dist)
            return -1;
        return 0;
    }
}

class Node {
    int num;
    int dist;
    int extra;

    public Node(int num) {
        this.num = num;
        this.dist = Integer.MAX_VALUE;
        this.extra = 0;
    }
}

class Edge {
    Node dis;
    int cost;

    public Edge(Node dis, int cost) {
        this.cost = cost;
        this.dis = dis;
    }
}

public class nikola {
    public static void main(String[] args) throws IOException {
        FastReader f = new FastReader();
        int m = f.nextInt();
        Node[][] nodes = new Node[m - 1][m];
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        Node n;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < Math.min(m, 1 + (i * (i+1) /2)); j++) {
                n = new Node(j);
                n.extra = i;
                nodes[i][j] = n;
            }
        }
        nodes[0][0].dist = 0;
        pq.add(nodes[0][0]);
        boolean[][] visited = new boolean[m - 1][m];
        boolean[][] inpq = new boolean[m - 1][m];
        inpq[0][0] = true;

        int[] cost = new int[m];

        for (int i = 0; i < m; i++) {
            cost[i] = f.nextInt();
        }


        while (true) {
            n = pq.poll();
            visited[n.extra][n.num] = true;

            if (n.num == m - 1){
                System.out.println(n.dist);
                break;
            }
            if (n.extra == m - 2) {
                System.out.println(n.dist + cost[m-1]);
                break;
            }
            if (n.num + n.extra + 1 < m && !visited[n.extra + 1][n.num + n.extra + 1]) {
                int alt = n.dist + cost[n.num + n.extra + 1];
                if (inpq[n.extra + 1][n.num + n.extra + 1]) {
                    pq.remove(nodes[n.extra + 1][n.num + n.extra + 1]);
                }
                nodes[n.extra + 1][n.num + n.extra + 1].dist = alt;
                pq.add(nodes[n.extra + 1][n.num + n.extra + 1]);
                inpq[n.extra + 1][n.num + n.extra + 1] = true;
            }
            if (n.num >= n.extra && !visited[n.extra][n.num - n.extra]) {
                int alt = n.dist + cost[n.num - n.extra];
                if (inpq[n.extra][n.num - n.extra]) {
                    pq.remove(nodes[n.extra][n.num - n.extra]);
                }
                nodes[n.extra][n.num - n.extra].dist = alt;
                pq.add(nodes[n.extra][n.num - n.extra]);
                inpq[n.extra][n.num - n.extra] = true;
            }
        }

    }
}
