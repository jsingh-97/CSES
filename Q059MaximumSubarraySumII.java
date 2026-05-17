import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;

public class Q059MaximumSubarraySumII {
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
    public static void main(String[] args) throws  IOException{
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int a = fr.nextInt();
        int b = fr.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = fr.nextInt();
        }
        TreeMap<Long, Integer> sumMap = new TreeMap<>();
        long[] prefixSum = new long[n + 1];
        prefixSum[0] = 0;
        long ans = Long.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
            if(i >= a){
                sumMap.put(prefixSum[i - a], sumMap.getOrDefault(prefixSum[i - a], 0) + 1);
            }
            if(i > b){
                long sumToRemove = prefixSum[i - b - 1];
                sumMap.put(sumToRemove, sumMap.get(sumToRemove) - 1);
                if(sumMap.get(sumToRemove) == 0){
                    sumMap.remove(sumToRemove);
                }
            }
            if(!sumMap.isEmpty()){
                ans = Math.max(ans, prefixSum[i] - sumMap.firstKey());
            }
        }
        System.out.print(ans);
    }
}
