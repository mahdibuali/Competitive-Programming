import java.io.IOException;
import java.util.Stack;

public class evenup {
    public static void main(String[] args) throws IOException {
        FastReader f = new FastReader();
        int n = f.nextInt();
        Stack<Integer> s = new Stack<>();
        int r = 0;
        for (int i = 0; i < n; i++) {
            r = f.nextInt();
            if (!s.isEmpty() && (s.peek() + r) % 2 == 0) {
                s.pop();
            }
            else {
                s.push(r);
            }
        }
        System.out.println(s.size());
    }
}
