import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Q030MovieFestival {
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
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = fr.nextInt();
            arr[i][1] = fr.nextInt();
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        int ans = 1;
        int prevEnd = arr[0][1];
        for(int i = 1; i < arr.length; i++){
            if(prevEnd <= arr[i][0]){
                ans++;
                prevEnd = arr[i][1];
            }
        }
       System.out.println(ans);
    }
}
