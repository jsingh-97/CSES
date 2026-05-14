import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Q054SubarraySumII {
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
    public static void main(String[] args) throws IOException{
        Q053SubarraySumI.FastReader fr = new Q053SubarraySumI.FastReader();
        int n = fr.nextInt();
        int x = fr.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = fr.nextInt();
        }
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        long cursum = 0, ans = 0;
        for(int i = 0; i < n; i++){
            cursum += arr[i];
            long target = cursum - x;
            ans += map.getOrDefault(target, 0);
            map.put(cursum, map.getOrDefault(cursum, 0) + 1);
        }
        System.out.print(ans);
    }
}
