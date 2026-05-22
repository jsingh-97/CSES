import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q088RoundTrip {
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
    static class UnionFind{
        int[] parent;
        int[] rank;
        int components;
        public UnionFind(int n){
            this.components = n;
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x){
            if(x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return;
            if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
                rank[rootY]++;
            }else{
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            components--;
        }
    }
    private static List<Integer> bfs(List<List<Integer>> adjls, int src, int dest){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[adjls.size()];
        int[] parent = new int[adjls.size()];
        q.offer(src);
        while(!q.isEmpty()){
            int node = q.poll();
            if(node == dest){
                break;
            }
            for(int neigh: adjls.get(node)){
                if(!vis[neigh]){
                    vis[neigh] = true;
                    q.offer(neigh);
                    parent[neigh] = node;
                }
            }
        }
        // build the path
        List<Integer> path = new ArrayList<>();
        int node = dest;
        while(node != src){
            path.add(node);
            node = parent[node];
        }
        path.add(src);
        path.add(dest);
        return path;
    }
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int m = fr.nextInt();
        int n = fr.nextInt();
        List<List<Integer>> adjls = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            adjls.add(new ArrayList<>());
        }
        boolean isPossible = false;
        UnionFind uf = new UnionFind(m);
        for (int i = 0; i < n; i++) {
            int a = fr.nextInt() - 1;
            int b = fr.nextInt() - 1;
            if(uf.find(a) == uf.find(b)){
                // we have found the cycle
                // do a bfs from a to b, find the path, the path will always have more than 2 nodes as we are not adding current edge and it is given that there is at most one edge between two nodes
                List<Integer> path = bfs(adjls, a, b);
                System.out.println();
                System.out.println(path.size());
                path.forEach(num -> System.out.print((num + 1) + " "));
                isPossible = true;
                break;
            }
            adjls.get(a).add(b);
            adjls.get(b).add(a);
            uf.union(a, b);
        }
        if(!isPossible){
            System.out.print("IMPOSSIBLE");
        }
    }
}
