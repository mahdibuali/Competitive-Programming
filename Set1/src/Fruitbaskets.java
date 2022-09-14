import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fruitbaskets {
    int n;
    int k;
    int[] fr;
    int[] l;
    ArrayList<List<Integer>> pl;

    public Fruitbaskets() {
    }

    void rec(int i, int j) {
        if (j == k) {
            ArrayList<Integer> list = new ArrayList<>(k);
            for (int x: l) {
                list.add(x);
            }
            pl.add(list);
        } else {
            l[j] = fr[i - 1];
            rec(i + 1, j + 1);
            if (n - i >= k - j) {
                rec(i + 1, j);
            }
        }
    }
    public ArrayList<List<Integer>> comb(int n, int k, int[] fr) {
        this.fr = fr;
        this.n = n;
        this.k = k;
        this.l = new int[k];
        this.pl = new ArrayList<>();
        rec(1, 0);
        return pl;
    }

    public static void main(String[] args) {
        Fruitbaskets f = new Fruitbaskets();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = s.nextInt();
        }
        int bad_sum = 0;
        long good_sum = 0;
        for (int y: x) {
            good_sum += y;
            if (y < 200) {
                bad_sum += y;
            }
        }
        ArrayList<List<Integer>> two_items = f.comb(n, 2, x);
        for (List y: two_items) {
            int sum = 0;
            for (Object z: y) {
                sum += (int) z;
            }
            if (sum < 200) {
                bad_sum += sum;
            }
        }

        ArrayList<List<Integer>> three_items = f.comb(n, 3, x);
        for (List y: three_items) {
            int sum = 0;
            for (Object z: y) {
                sum += (int) z;
            }
            if (sum < 200) {
                bad_sum += sum;
            }
        }
        good_sum *= Math.pow(2, n - 1);

        good_sum -= bad_sum;
        System.out.println(good_sum);
    }
}
