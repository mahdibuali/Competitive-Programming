import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CountingPaths {

    public static void main(String[] args) throws IOException {
        FastReader f = new FastReader();
        int n = f.nextInt();
        int x = f.nextInt() - 1;
        int y = f.nextInt() - 1;
        ArrayList<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = f.nextInt();
            int v = f.nextInt();
            edges[u - 1].add(v - 1);
            edges[v - 1].add(u - 1);
        }
        boolean[] visited = new boolean[n];
        visited[x] = true;
        int p = 1;
        int q = 0;
        for (int v: edges[x]) {
            int[] s = dfs(edges, visited, v, y);
            if (s[0] == 0) {
                p += s[1];
            } else q+= s[1];
        }
        long a = p;
        long b = q;
        long r = n;
        System.out.println(r * (r-1) - b * a);
    }
    public static int[] dfs(ArrayList<Integer>[] edges, boolean[] visited, int v, int y) {
        visited[v] = true;
        int[] t = new int[2];
        t[1] = 1;
        if (v == y) {
            t[0] = 1;
        }
        for (int w: edges[v]) {
            if (!visited[w]) {
                int[] s = dfs(edges, visited, w, y);
                if (s[0] == 0) {
                    t[1] += s[1];
                } else return s;
            }
        }
        return t;
    }
}

