import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q094CycleFinding {
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
        int[][] edges = new int[m][3];
        for(int i = 0; i < m; i++){
            edges[i][0] = fr.nextInt();
            edges[i][1] = fr.nextInt();
            edges[i][2] = fr.nextInt();
        }
        long[] dist = new long[n + 1];
        Arrays.fill(dist, 0);
        int[] prev = new int[n + 1];
        Arrays.fill(prev, 0);
        Integer pathEnd = null;
        for(int i = 1; i <= n; i++){
            for(int[] edge: edges){
                int u = edge[0], v = edge[1], c = edge[2];
                long newDist = dist[u] + c;
                if(newDist < dist[v]){
                    dist[v] = newDist;
                    prev[v] = u;
                    if(i == n){
                        pathEnd = v;
                    }
                }
            }
        }
        if(pathEnd == null){
            System.out.println("NO");
        }else{
            System.out.println("YES");
            List<Integer> path = new ArrayList<>();
            boolean[] visited = new boolean[n + 1];
            // walk back n steps so that x is the code in the cycle
            int x = pathEnd;
            for (int i = 0; i < n; i++) {
                x = prev[x];
            }
            while(true){
                path.add(x);
                if(visited[x]) break;
                visited[x] = true;
                x = prev[x];
            }
            Collections.reverse(path);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < path.size(); i++){
                sb.append(path.get(i)).append(" ");
                if(i > 0 && path.get(i) == path.get(0)){
                    break;
                }
            }
            System.out.println(sb);
        }
    }
}
