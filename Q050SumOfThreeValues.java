import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Q050SumOfThreeValues {
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
        int target = fr.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = fr.nextInt();
            arr[i][1] = i + 1;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        boolean answerFound = false;
        for(int i = 0; i < arr.length - 2; i++){
            int sum = target - arr[i][0];
            int start = i + 1, end = arr.length - 1;
            while(start < end){
                if((arr[start][0] + arr[end][0]) == sum){
                    answerFound = true;
                    System.out.print(arr[i][1] + " " + arr[start][1] + " " + arr[end][1]);
                    break;
                }else if((arr[start][0] + arr[end][0]) > sum){
                    end--;
                }else{
                    start++;
                }
            }
            if(answerFound){
                break;
            }
        }
        if(!answerFound){
            System.out.println("IMPOSSIBLE");
        }
    }
}
