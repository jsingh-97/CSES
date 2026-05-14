import java.io.IOException;
import java.io.InputStream;


public class Q057ArrayDivision {
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
    // binary search on the sum
    // greedy
    // dp
    public static void main(String[] args) throws IOException{
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int k = fr.nextInt();
        int[] nums = new int[n];
        long totalSum = 0;
        for(int i = 0; i < n; i++){
            nums[i] = fr.nextInt();
            totalSum += nums[i];
        }
        long start = 0, end = totalSum;
        long ans = -1;
        while(start <= end){
            long mid = start + (end - start) / 2;
            if(isValid(nums, mid, k)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }
    private static boolean isValid(int[] nums, long sum, int k){
        long cursum = 0;
        long curPartitions = 1;
        for(int num: nums){
            if(num > sum) return false;
            if((cursum + num) <= sum){
                cursum += num;
            }else{
                curPartitions++;
                cursum = num;
            }
        }
        return curPartitions <= k;
    }
}
