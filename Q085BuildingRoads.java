import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Q085BuildingRoads {
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
    public static void main(String[] args) throws IOException{
        FastReader fr = new FastReader();
        int m = fr.nextInt();
        int n = fr.nextInt();
        UnionFind uf = new UnionFind(m);
        for(int i = 0; i < n; i++){
            int a = fr.nextInt();
            int b = fr.nextInt();
            uf.union(a - 1, b - 1);
        }
        Set<Integer> roots = new HashSet<>();
        for(int i = 0; i < uf.parent.length; i++){
            roots.add(uf.find(uf.parent[i]));
        }
        int firstRoot = roots.iterator().next();
        System.out.println(roots.size() - 1);
        for(int root: roots){
            if(firstRoot != root){
                System.out.println((firstRoot + 1) + " " + (root + 1));
            }
        }
    }
}
