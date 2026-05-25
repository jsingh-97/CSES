import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


public class Q091ShortestRouteII {
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
        int m = fr.nextInt();
        int n = fr.nextInt();
        int q = fr.nextInt();
        long[][] dist = new long[m][m];
        for(int i = 0; i < m; i++){
            Arrays.fill(dist[i], -1);
            dist[i][i] = 0;
        }
        for(int i = 0; i < n; i++){
            int a = fr.nextInt()- 1;
            int b = fr.nextInt() - 1;
            long len = fr.nextInt();
            if(dist[a][b] == -1){
                dist[a][b] = len;
                dist[b][a] = len;
            }else{
                dist[a][b] = Math.min(dist[a][b], len);
                dist[b][a] = Math.min(dist[b][a], len);

            }

        }
        for(int k = 0; k < m; k++){
            for(int i = 0; i < m; i++){
                for(int j = 0; j < m; j++){
                    if(dist[i][k] != -1 && dist[k][j] != -1){
                        if(dist[i][j] != -1){
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }else{
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++){
            int a = fr.nextInt() - 1;
            int b = fr.nextInt() - 1;
            sb.append(dist[a][b]).append("\n");
        }
        System.out.println(sb);
    }
}
