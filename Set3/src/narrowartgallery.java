import java.io.IOException;

public class narrowartgallery {

    public static int max(int a, int b, int c) {
        if (c == 0) {
            if (a > b) {
                return a;
            }
            return b;
        }
        if (a >= b && a >= c) {
            return a;
        }
        if (b > c) {
            return b;
        }
        return c;
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] g = new int[n][2];
        for (int i = 0; i < n; i++) {
            g[i][0] = in.nextInt();
            g[i][1] = in.nextInt();
        }

        int[][] E = new int[k + 1][g.length + 1];
        int[][] L = new int[k + 1][g.length + 1];
        int[][] R = new int[k + 1][g.length + 1];

        int sum = 0;
        for (int i = 0; i < g.length; i++) {
            sum += g[i][0] + g[i][1];
            E[0][i + 1] = sum;
        }

        for (int i = 1; i < E[0].length; i++) {
            for (int j = max(k - g.length + i, 1, 0); j <= Math.min(i, E.length - 1); j++) {
                L[j][i] = g[i - 1][1] + max(L[j-1][i-1], E[j -1][i - 1], 0);
                R[j][i] = g[i - 1][0] + max(R[j-1][i-1], E[j -1][i - 1], 0);
                if (j < i) {
                    E[j][i] = g[i - 1][0] + g[i - 1][1] + max(E[j][i - 1], L[j][i - 1], R[j][i - 1]);
                }
            }
        }
        System.out.println(max(E[k][g.length], R[k][g.length], L[k][g.length]));
    }
}
