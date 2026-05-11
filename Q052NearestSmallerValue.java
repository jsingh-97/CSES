import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q052NearestSmallerValue {
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
        for(int i = 0; i < arr.length; i++){
            arr[i] = fr.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        //monotonic increasing stack
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++){
            if(dq.isEmpty() || arr[dq.peek()] < arr[i]){
                int ans = dq.isEmpty()?0 : dq.peek() + 1;
                sb.append(ans).append(" ");
                dq.push(i);
            }else{
                while(!dq.isEmpty() && arr[dq.peek()] >= arr[i]){
                    dq.pop();
                }
                i--;
            }
        }
        System.out.print(sb);
    }
}
