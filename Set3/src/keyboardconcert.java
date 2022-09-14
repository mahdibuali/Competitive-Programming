import java.io.IOException;
import java.util.ArrayList;

public class keyboardconcert {

    public static void main(String[] args) throws IOException {
        FastReader f = new FastReader();
        int n = f.nextInt();
        int m = f.nextInt();

        ArrayList<Integer> inst[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> r = new ArrayList<>();
            int k = f.nextInt();
            for (int j = 0; j < k; j++) {
                r.add(f.nextInt());
            }
            inst[i] = r;
        }

        int[] notes = new int[m];
        for (int i = 0; i < m; i++) {
            notes[i] = f.nextInt();
        }

        int[][] l = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (inst[i].contains(notes[0])){
                l[0][i] = 0;
            } else {
                l[0][i] = Integer.MAX_VALUE;
            }
        }
        int min1 = 0;
        int min2 = Integer.MAX_VALUE;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (inst[j].contains(notes[i])){
                    l[i][j] = Math.min(l[i - 1][j], min1 + 1);
                    if (l[i][j] < min2) {
                        min2 = l[i][j];
                    }
                } else {
                    l[i][j] = Integer.MAX_VALUE;
                }
            }
            min1 = min2;
            min2 = Integer.MAX_VALUE;
        }
        System.out.println(min1);
    }
}
