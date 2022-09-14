import java.io.IOException;

public class BaseStation {
    public static void main(String[] args) throws IOException {
        FastReader f = new FastReader();
        int n = f.nextInt();
        int m = f.nextInt();
        int[] houses = new int[n];
        int[] stations = new int[m];

        for (int i = 0; i < n; i++) {
            houses[i] = f.nextInt();
        }
        for (int i = 0; i < m; i++) {
            stations[i] = f.nextInt();
        }

        int currHouse = 0;
        int currStation = 0;
        int r = 0;
        while (currHouse < n) {
            if (currStation == m - 1) {
                if (Math.abs(houses[currHouse] - stations[currStation]) > r) {
                    r = Math.abs(houses[currHouse] - stations[currStation]);
                }
                currHouse++;
            } else if (houses[currHouse] <= (stations[currStation] + stations[currStation + 1])/2) {
                if (Math.abs(houses[currHouse] - stations[currStation]) > r) {
                    r = Math.abs(houses[currHouse] - stations[currStation]);
                }
                currHouse++;
            } else {
                currStation++;
            }
        }
        System.out.println(r);
    }
}
