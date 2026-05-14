import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Q056DistinctValuesSubarraysII {
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
        int k = fr.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = fr.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        for(int start = 0, end = 0; end < nums.length; end++){
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            //validate the window
            while(map.size() > k){
                //delete from start
                map.put(nums[start], map.get(nums[start]) - 1);
                if(map.get(nums[start]) == 0){
                    map.remove(nums[start]);
                }
                start++;
            }
            ans += (end - start + 1);
        }
        System.out.println(ans);
    }
}
