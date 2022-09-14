import java.io.IOException;
import java.util.PriorityQueue;

public class millionairemadness {
    public static void main(String[] args) throws IOException {
        FastReader f = new FastReader();
        int n = f.nextInt();
        int m = f.nextInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = f.nextInt();
            }
        }
        int[][] v = new int[n][m];
        v[0][0] = 1;
        PriorityQueue<Edge1> pq = new PriorityQueue(n * m , new EdgeComparator());
        if (m > 1) {
            pq.add(new Edge1(Math.max(mat[0][1] - mat[0][0], 0), 0, 1));
        }
        if (n > 1) {
            pq.add(new Edge1(Math.max(0, mat[1][0] - mat[0][0]), 0, m));
        }
        if (n * m == 1) {
            System.out.println(0);
            return;
        }
        int r = 0;
        while (true) {
            Edge1 e = pq.remove();
            if (v[e.node2 / m][e.node2 % m] == 0) {
                v[e.node2 / m][e.node2 % m] = 1;
                r = Math.max(r, e.val);
                if (e.node2 == n * m - 1) {
                    System.out.println(r);
                    return;
                }
                // add edges

                if (e.node2 >= m) {
                    int x = e.node2 - m;
                    if (v[x / m][x % m] == 0) {
                        pq.add(new Edge1(Math.max(0, mat[x / m][x % m] - mat[e.node2 / m][e.node2 % m]), e.node2, x));
                    }
                }

                if (e.node2 < (n - 1) * m) {
                    int x = e.node2 + m;
                    if (v[x / m][x % m] == 0) {

                        pq.add(new Edge1(Math.max(0, mat[x / m][x % m] - mat[e.node2 / m][e.node2 % m]), e.node2, x));
                    }
                }
                if (e.node2 % m != 0) {
                    int x = e.node2 - 1;
                    if (v[x / m][x % m] == 0) {

                        pq.add(new Edge1(Math.max(0, mat[x / m][x % m] - mat[e.node2 / m][e.node2 % m]), e.node2, x));
                    }
                }
                if (e.node2 % m != m - 1) {
                    int x = e.node2 + 1;
                    if (v[x / m][x % m] == 0) {

                        pq.add(new Edge1(Math.max(0, mat[x / m][x % m] - mat[e.node2 / m][e.node2 % m]), e.node2, x));
                    }
                }
            }
        }

    }
}
