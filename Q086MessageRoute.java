import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Q086MessageRoute {
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
    private static int bfs(List<List<Integer>> adjls, int src, int dest, int[] path){
        boolean[] vis = new boolean[dest + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        vis[src] = true;
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int node = q.poll();
                if (node == dest) {
                    return steps;
                }
                for (int neigh : adjls.get(node)) {
                    if (!vis[neigh]) {
                        q.offer(neigh);
                        vis[neigh] = true;
                        path[neigh] = node;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        FastReader fr = new FastReader();
        int m = fr.nextInt();
        int n = fr.nextInt();
        List<List<Integer>> adjls = new ArrayList<>();
        for(int i = 0; i <= m; i++){
            adjls.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            int a = fr.nextInt();
            int b = fr.nextInt();
            adjls.get(a).add(b);
            adjls.get(b).add(a);
        }
        int[] path = new int[m + 1];
        int ans = bfs(adjls, 1, m, path);
        if(ans == -1){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println(ans + 1);
            List<Integer> ls = new ArrayList<>();
            int node = m;
            while(node != 1){
                ls.add(node);
                node = path[node];
            }
            ls.add(node);
            Collections.reverse(ls);
            ls.forEach(num -> System.out.print(num + " "));
        }
    }
}
