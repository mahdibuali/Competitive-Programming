import java.io.IOException;

public class ladice {
    public static boolean empty(int l, item[] L, UF v, UF w) {
        item t = L[l];
        int k = 0;
        if (t.A == l) {
            k = t.B;
        } else {
            k = t.A;
        }
        if (v.find(l) == v.find(k)) {
            return false;
        }
        if (L[k] == null) {
            L[k] = t;
            L[l] = null;
            return true;
        }
        v.union(l, k);
        if (empty(k, L, v, w)) {
            L[k] = t;
            L[l] = null;
            return true;
        }
        w.union(l, k);
        return false;
    }

    public static void main(String[] args) throws IOException {
        FastReader f = new FastReader();
        int n = f.nextInt();
        int l = f.nextInt();
        item[] L = new item[l];
        UF w = new UF(l);
        for (int i = 0; i < n; i++) {
            UF v = new UF(w);
            int x = f.nextInt();
            int y = f.nextInt();
            item t = new item(i, x - 1, y - 1);
            if (L[t.A] == null) {
                L[t.A] = t;
                System.out.println("LADICA");
            } else if (L[t.B] == null) {
                L[t.B] = t;
                System.out.println("LADICA");
            } else if (empty(t.A, L, v, w)) {
                L[t.A] = t;
                System.out.println("LADICA");
            } else if (empty(t.B, L, v, w)) {
                L[t.B] = t;
                System.out.println("LADICA");
            } else {
                System.out.println("SMECE");
            }

        }
    }
}

class item {
    int no;
    int A;
    int B;

    public item(int no, int A, int B) {
        this.no = no;
        this.A = A;
        this.B = B;
    }
}