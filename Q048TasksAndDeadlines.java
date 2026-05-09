import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Q048TasksAndDeadlines {
    static class FastReader {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = read();
            } while (c <= ' ');//skip space, \n, \t

            if (c == '-') {
                sign = -1;
                c = read();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }

            return val * sign;
        }
    }
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        long[] durations = new long[n];
        long totalDeadlines = 0;
        for(int i = 0; i < n; i++){
            durations[i] = fr.nextInt();
            totalDeadlines += fr.nextInt();
        }
        long maxReward = totalDeadlines;
        Arrays.sort(durations);
        int mul = 1;
        for(int i = durations.length - 1; i >= 0; i--, mul++){
            maxReward -= mul * durations[i];
        }
        System.out.println(maxReward);
    }
}
