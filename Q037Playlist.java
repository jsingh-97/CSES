import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class Q037Playlist {
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
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = fr.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int end = 0, start = 0; end < n; end++){
            if(map.containsKey(arr[end]) && start <= map.get(arr[end])){
                start = map.get(arr[end]) + 1;
            }
            ans = Math.max(ans, end - start + 1);
            map.put(arr[end], end);
        }
        System.out.println(ans);
    }
}
