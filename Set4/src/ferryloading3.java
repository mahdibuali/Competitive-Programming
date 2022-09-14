import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ferryloading3 {
    public static void main(String[] args) throws IOException {
        FastReader f = new FastReader();
        int c = f.nextInt();
        PrintWriter o = new PrintWriter(System.out);
        for (int j = 0; j < c; j++) {
            int n = f.nextInt();
            int t = f.nextInt();
            int m = f.nextInt();
            Queue<Integer> left = new LinkedList<>();
            Queue<Integer> right = new LinkedList<>();
            char[] car = new char[m];
            int car_counter = 0;
            char current_side = 'l';
            int curr_time = 0;
            int h = f.nextInt();
            String s = f.nextLine();
            car[0] = s.charAt(0);
            int w = 1;
            int l =0; int r = 0;
            while (car_counter < m) {
                while (w < m + 1){
                    if (h <= curr_time) {
                        if (s.charAt(0) == 'l') {
                            l++;
                        } else {
                            r++;
                        }
                    }
                    else {
                        break;
                    }
                    if (w < m) {
                        h = f.nextInt();
                        s = f.nextLine();
                        car[w] = s.charAt(0);
                    }
                    w++;
                }
                if (l != 0 || r != 0) {
                    if (current_side == 'l') {
                        for (int i = 0; i < Math.min(n, l); i++) {
                            left.add(curr_time + t);
                            //o.println(curr_time + t);
                            car_counter++;
                        }
                        l -= Math.min(n, l);
                        current_side = 'r';
                    } else {
                        for (int i = 0; i < Math.min(n, r); i++) {
                            right.add(curr_time + t);
                            //o.println(curr_time + t);
                            car_counter++;
                        }
                        r -= Math.min(n, r);
                        current_side = 'l';
                    }
                    curr_time += t;
                } else {
                    curr_time = h;
                }
            }
            for (int i = 0; i < m; i++) {
                if (car[i] == 'l') {
                    o.println(left.remove());
                } else {
                    o.println(right.remove());
                }
            }
            o.println();
        }
        o.close();
    }
}
