import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Q036CollectingNumbersII {
    static int N = 200001;
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
        int m = fr.nextInt();
        int[] arr = new int[n];
        int[] pos = new int[N];
        for(int i = 0; i < n; i++) {
            arr[i] = fr.nextInt();
            pos[arr[i]] = i;
        }
        int operations = getInitialOperations(arr, pos);
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int a = fr.nextInt() - 1;
            int b = fr.nextInt() - 1;
            if(a > b){
                int t = a;
                a = b;
                b = t;
            }
            int val1 = arr[a];
            int val2 = arr[b];
            if(a < pos[val1 - 1] && pos[val1 - 1] < b){
                operations--;
            }
            if(a < pos[val1 + 1] && pos[val1 + 1] < b){
                operations++;
            }
            if(a < pos[val2 - 1] && pos[val2 - 1] < b){
                operations++;
            }
            if(a < pos[val2 + 1] && pos[val2 + 1] < b){
                operations--;
            }
            if((val1 + 1) == val2){
                operations++;
            }
            if((val1 - 1) == val2){
                operations--;
            }
            swap(arr, a, b);
            pos[val1] = b;
            pos[val2] = a;
            ans.append(operations).append("\n");
        }
        System.out.println(ans);
    }
    private static void swap(int[] arr, int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
    private static int getInitialOperations(int[] arr, int[] pos) {
        int operations = 0;
        for(int i = 0; i < arr.length; i++){
            int num = arr[i];
            if(i == 0 || num == 1){
                operations++;
            }else{
                if(pos[num - 1] > i){
                    operations++;
                }
            }
        }
        return operations;
    }
}
