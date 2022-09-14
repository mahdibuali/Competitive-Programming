import java.util.*;

public class Test {
    public static void main(String[] args) {
        Hashtable<Integer, int[]> l = new Hashtable<>();
        l.put(1, new int[]{10,10});
        l.put(2, new int[]{12,12});
        int[] k = new int[0];
        ArrayList<Integer> x = new ArrayList<>();
        PriorityQueue<Integer> s = new PriorityQueue<>(3, Collections.reverseOrder());
        s.add(1); s.add(2); s.add(3);
        System.out.println(s.peek());
    }
}
