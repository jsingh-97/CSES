import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;

public class Q029RestaurantCustomers {
    // This is to avoid TLE in java
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
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++){
            int startTime = fr.nextInt();
            int endTime = fr.nextInt();
            map.put(startTime, map.getOrDefault(startTime, 0) + 1);
            map.put(endTime + 1, map.getOrDefault(endTime + 1, 0) - 1);
        }
        int ans = 0, runningSum = 0;
        for(int val: map.values()){
            runningSum += val;
            ans = Math.max(ans, runningSum);
        }
        System.out.println(ans);
    }
}
