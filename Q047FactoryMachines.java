import java.io.IOException;
import java.io.InputStream;

public class Q047FactoryMachines {
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
        long p = fr.nextInt();
        int[] arr = new int[n];
        long minTimeMachine = Long.MAX_VALUE;
        for(int i = 0; i < n; i++){
            arr[i] = fr.nextInt();
            minTimeMachine = Math.min(minTimeMachine, arr[i]);
        }
        long start = 0, end = minTimeMachine * p;
        long ans = 0;
        while(start <= end){
            long mid = start + (end - start) / 2;
            if(valid(mid, arr, p)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }
    private static boolean valid(long mid, int[] arr, long p){
        long productsMade = 0;
        for(int a: arr){
            productsMade += (mid / a);
        }
        return productsMade >= p;
    }
}
