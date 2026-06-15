import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q092HighScore {
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
    private static void dfs(List<List<Integer>> graph, boolean[] vis, int node){
        vis[node] = true;
        for(int neigh: graph.get(node)){
            if(!vis[neigh]){
                dfs(graph, vis, neigh);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int m = fr.nextInt();
        int[][] edges = new int[m][3];
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> revGraph = new ArrayList<>();
        for(int i = 0; i < n + 1; i++){
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            int a = fr.nextInt(), b = fr.nextInt();
            int x = fr.nextInt();
            edges[i][0] = a; edges[i][1] = b; edges[i][2] = -x;
            graph.get(a).add(b);
            revGraph.get(b).add(a);
        }
        boolean[] visited1 = new boolean[n + 1];
        boolean[] visited2 = new boolean[n + 1];
        dfs(graph, visited1, 1);
        dfs(revGraph, visited2, n);
        boolean isCycle = false;
        for(int k = 0; k <= n + 1; k++){
            isCycle = false;
            for(int[] edge: edges){
                int u = edge[0], v = edge[1], score = edge[2];
                if(visited1[u] && visited2[v] && dist[u] != Long.MAX_VALUE && dist[v] > (dist[u] + score)){
                    dist[v] = dist[u] + score;
                    isCycle = true;
                }
            }
        }
        if(isCycle){
            System.out.println(-1);
        }else{
            System.out.println(-dist[n]);
        }

    }
}
