import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CoffeeBreak1 {
    public static void main(String[] args) throws IOException, IOException {
        FastReader f = new FastReader();
        int t = f.nextInt();
        for (int j = 0; j < t; j++) {
            int n = f.nextInt();
            int m = f.nextInt();
            ArrayList<Integer>[] edges = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int u = f.nextInt();
                int v = f.nextInt();
                edges[u - 1].add(v - 1);
                edges[v - 1].add(u - 1);
            }
            boolean[] visited = new boolean[n];
            int[] parent = new int[n];
            Queue<Integer> s = new LinkedList<>();
            s.add(0);
            visited[0] = true;
            boolean b = false;
            while (!s.isEmpty()) {
                int v = s.poll();
                for (int i = 0; i < edges[v].size(); i++) {
                    int w = edges[v].get(i);
                    if (!visited[w]) {
                        s.add(w);
                        parent[w] = parent[v] + 1;
                        visited[w] = true;
                    }
                    if (w == 1) {
                        b = true;
                        break;
                    }
                }
                if (b) break;
            }
            if (visited[2]) {
                boolean[] visited2 = new boolean[n];
                int[] parent2 = new int[n];
                Queue<Integer> s2 = new LinkedList<>();
                s2.add(2);
                visited2[2] = true;
                boolean d = false;
                while (!s2.isEmpty()) {
                    int v = s2.poll();
                    for (int i = 0; i < edges[v].size(); i++) {
                        int w = edges[v].get(i);
                        if (!visited2[w]) {
                            s2.add(w);
                            parent2[w] = parent2[v] + 1;
                            visited2[w] = true;
                        }
                        if (parent2[w] > parent[1] - parent[2]) {
                            System.out.println("NO");
                            d = true;
                            break;
                        }
                        if (w == 1) {
                            System.out.println("YES");
                            d = true;
                            break;
                        }
                    }
                    if (d) break;

                }
            } else System.out.println("NO");
        }
    }
}
