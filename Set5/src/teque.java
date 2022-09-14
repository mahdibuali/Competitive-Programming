import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class teque {
     Dequeue left;
     Dequeue right;
     int size;
     public teque(){
         left = new Dequeue();
         right = new Dequeue();
         size = 0;
     }

     public void pushFront(int item) throws Exception {
         if ((size % 2) == 1) {
             right.pushFront(left.popBack());
         }
         left.pushFront(item);
         size++;
     }

    public void pushBack(int item) throws Exception {
        if ((size % 2) == 0) {
            if (size == 0) {
                left.pushFront(item);
                size++;
                return;
            } else {
                left.pushBack(right.popFront());
            }
        }
        right.pushBack(item);
        size++;
    }

    public void pushMiddle(int item) throws Exception {
        if ((size % 2) == 1) {
            right.pushFront(item);
        }
        else {
            left.pushBack(item);
        }
        size++;
    }

    public int get(int index) {
         int n = left.size();
         if (index < n) {
             return left.get(index);
         }
         return right.get(index - n);
    }

    public static void main(String[] args) throws Exception {
         FastReader f = new FastReader();
         PrintWriter o = new PrintWriter(System.out);
        int n = f.nextInt();
        teque t = new teque();
        for (int i = 0; i < n; i++) {
            String s = f.next();
            int x = f.nextInt();
            if (s.charAt(0) == 'g') {
                o.println(t.get(x));
            } else {
                if (s.charAt(5) == 'b') {
                    t.pushBack(x);
                } else if (s.charAt(5) == 'f') {
                    t.pushFront(x);
                } else {
                    t.pushMiddle(x);
                }
            }
        }
        o.close();
    }
}
