import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class CardDealer {
    public static int choose2(int k) {
        return (k * (k-1)) /2;
    }
    public static void main(String[] args) throws IOException {
        FastReader f = new FastReader();
        int t = f.nextInt();
        for (int i = 0; i < t; i++) {
            int n = f.nextInt();
            int[] freq = new int[2 * n];
            int result = 0;
            int l = n;
            int r = n;
            for (int j = 0; j < 2 * n; j++) {
                freq[f.nextInt() - 1]--;
            }
            Arrays.sort(freq);
            int c = 0;
            while ((l > 1 || r > 1) && -freq[c] > 1) {
                if (-freq[c] <= l) {
                    l += freq[c];
                    result += choose2(-freq[c]);
                    c++;
                } else {
                    if (-freq[c] <= r) {
                        r += freq[c];
                        result += choose2(-freq[c]);
                        c++;
                    } else if (l > r) {
                        result += choose2(l);
                        freq[c] = freq[c] + l;
                        Arrays.sort(freq);
                        l = 0;
                    } else {

                        result += choose2(r);
                        freq[c] = freq[c] + r;
                        Arrays.sort(freq);
                        r = 0;

                    }
                }
            }
            System.out.println(result);
        }
    }
}
