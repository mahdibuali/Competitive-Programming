import java.io.IOException;

public class trainsorting {
    public static void main(String[] args) throws IOException {
        FastReader f = new FastReader();
        int n = f.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[] w = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            w[i] = f.nextInt();
        }
        int[] li = new int[n];
        int[] ld = new int[n];

        for (int i = 0; i < n; i++) {
            li[i] = 1;
            ld[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (w[i] > w[j] && li[i] <= li[j]) {
                    li[i] = li[j] + 1;
                }
                if (w[i] < w[j] && ld[i] <= ld[j]) {
                    ld[i] = ld[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < li[i] + ld[i]) {
                max = li[i] + ld[i];
            }
        }
        System.out.println(max - 1);
    }
}
