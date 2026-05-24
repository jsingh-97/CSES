import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Q090ShortestRouteI {
    static class Node{
        int node;
        long distance;
        public Node(int n, long distance){
            this.node = n;
            this.distance = distance;
        }
    }
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
        List<List<Node>> adjls = new ArrayList<>();
        for(int i = 0 ; i < m; i++){
            adjls.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            int a = fr.nextInt() - 1;
            int b = fr.nextInt() - 1;
            int len = fr.nextInt();
            adjls.get(a).add(new Node(b, len));
        }
        Comparator<Node> cmp = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Long.compare(o1.distance, o2.distance);
            }
        };
        PriorityQueue<Node> pq = new PriorityQueue<>(cmp); // node, distance from node 1
        pq.offer(new Node(0, 0));
        long[] dist = new long[m];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        while(!pq.isEmpty()){
            Node polledNode = pq.poll();
            int node = polledNode.node;
            long curDistance = polledNode.distance;
            if (curDistance > dist[node]) continue; // this saves TLE, good optimization to avoid processing stale entries
            for(Node neigh: adjls.get(node)){
                long newDistance = curDistance + neigh.distance;
                if(newDistance < dist[neigh.node]){
                    dist[neigh.node] = newDistance;
                    pq.offer(new Node(neigh.node, newDistance));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (long j : dist) {
            sb.append(j).append(" ");
        }
        System.out.println(sb);
    }
}
