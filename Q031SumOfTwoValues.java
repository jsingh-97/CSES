import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

public class Q031SumOfTwoValues {
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
        int targetSum = fr.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = fr.nextInt();
            arr[i][1] = i + 1;
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int s = 0, e = arr.length - 1;
        boolean solutionFound = false;
        while(s < e){
            if((arr[s][0] + arr[e][0]) == targetSum){
                solutionFound = true;
                System.out.println(arr[s][1] + " " + arr[e][1]);
                break;
            }else if((arr[s][0] + arr[e][0]) > targetSum){
                e--;
            }else{
                s++;
            }
        }
        if(!solutionFound){
            System.out.println("IMPOSSIBLE");
        }
    }
}
