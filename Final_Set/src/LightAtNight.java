import java.io.IOException;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


class FastReader {
    private final int BUFFER_SIZE = 65536;
    private int MAX_LINE_SIZE = 65536;
    private DataInputStream din;
    private byte[] buffer;
    private byte[] lineBuf;
    private int bufferPointer;
    private int bytesRead;

    public FastReader() {
        this.din = new DataInputStream(System.in);
        this.buffer = new byte[65536];
        this.lineBuf = new byte[this.MAX_LINE_SIZE];
        this.bufferPointer = this.bytesRead = 0;
    }

    public FastReader(String file_name) throws IOException {
        this.din = new DataInputStream(new FileInputStream(file_name));
        this.buffer = new byte[65536];
        this.bufferPointer = this.bytesRead = 0;
    }

    public boolean hasNext() throws IOException {
        while(true) {
            byte c;
            if ((c = this.read()) != -1) {
                if (c <= 32) {
                    continue;
                }

                --this.bufferPointer;
                return true;
            }

            return false;
        }
    }

    public String nextLine() throws IOException {
        int ctr = 0;
        boolean empty = true;

        byte c;
        while((c = this.read()) != -1) {
            if (c != 13) {
                if (c == 10) {
                    if (!empty) {
                        break;
                    }

                    ctr = 0;
                } else {
                    if (ctr == this.MAX_LINE_SIZE) {
                        this.MAX_LINE_SIZE *= 2;
                        this.lineBuf = Arrays.copyOf(this.lineBuf, this.MAX_LINE_SIZE);
                    }

                    this.lineBuf[ctr++] = c;
                    if (c > 32) {
                        empty = false;
                    }
                }
            }
        }

        return new String(this.lineBuf, 0, ctr);
    }

    public String next() throws IOException {
        int ctr = 0;

        byte c;
        for(c = this.read(); c <= 32; c = this.read()) {
        }

        while(c > 32) {
            if (ctr == this.MAX_LINE_SIZE) {
                this.MAX_LINE_SIZE *= 2;
                this.lineBuf = Arrays.copyOf(this.lineBuf, this.MAX_LINE_SIZE);
            }

            this.lineBuf[ctr++] = c;
            c = this.read();
        }

        return new String(this.lineBuf, 0, ctr);
    }

    public int nextInt() throws IOException {
        int ret = 0;

        byte c;
        for(c = this.read(); c <= 32; c = this.read()) {
        }

        boolean neg = c == 45;
        if (neg) {
            c = this.read();
        }

        do {
            ret = ret * 10 + c - 48;
        } while((c = this.read()) >= 48 && c <= 57);

        return neg ? -ret : ret;
    }

    public long nextLong() throws IOException {
        long ret = 0L;

        byte c;
        for(c = this.read(); c <= 32; c = this.read()) {
        }

        boolean neg = c == 45;
        if (neg) {
            c = this.read();
        }

        do {
            ret = ret * 10L + (long)c - 48L;
        } while((c = this.read()) >= 48 && c <= 57);

        return neg ? -ret : ret;
    }

    public double nextDouble() throws IOException {
        double ret = 0.0D;
        double div = 1.0D;

        byte c;
        for(c = this.read(); c <= 32; c = this.read()) {
        }

        boolean neg = c == 45;
        if (neg) {
            c = this.read();
        }

        do {
            ret = ret * 10.0D + (double)c - 48.0D;
        } while((c = this.read()) >= 48 && c <= 57);

        if (c == 46) {
            while((c = this.read()) >= 48 && c <= 57) {
                ret += (double)(c - 48) / (div *= 10.0D);
            }
        }

        return neg ? -ret : ret;
    }

    private void fillBuffer() throws IOException {
        this.bytesRead = this.din.read(this.buffer, this.bufferPointer = 0, 65536);
    }

    private byte read() throws IOException {
        if (this.bufferPointer == this.bytesRead) {
            this.fillBuffer();
        }

        return this.bytesRead <= 0 ? -1 : this.buffer[this.bufferPointer++];
    }

    public void close() throws IOException {
        if (this.din != null) {
            this.din.close();
        }
    }
}

public class LightAtNight {
    public static void main(String[] args) throws IOException {
        FastReader f = new FastReader();
        int n = f.nextInt();
        int m = f.nextInt();
        int[][] light = new int[n][n];
        int[][] Dlight = new int[n][n+1];
        int[][] path = new int[n][n];
        light[0][0] = 1;
        Dlight[0][0] = 1;

        light[n-1][n-1] = 1;
        Dlight[n-1][n-1] = 1;

        Dlight[0][1] = -1;
        Dlight[n-1][n] = -1;
        for (int i = 0; i < m; i++) {
            int xi = f.nextInt() - 1;
            int yi = f.nextInt() - 1;
            int xj = f.nextInt() - 1;
            int yj = f.nextInt() - 1;
            for (int j = yi; j <= yj; j++) {
                Dlight[j][xi]++;
                Dlight[j][xj + 1]--;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]);
                } else if (i == 0 && j > 0) {
                    path[i][j] = path[i][j - 1];
                } else if (i > 0) {
                    path[i][j] = path[i - 1][j];
                }
                if (j == 0) light[i][j] = Dlight[i][j];
                else light[i][j] = Dlight[i][j] + light[i][j - 1];
                if (light[i][j] == 0) path[i][j]++;
            }
        }
        System.out.println(path[n-1][n-1]);
    }
}
