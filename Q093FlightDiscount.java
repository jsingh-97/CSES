import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Q093FlightDiscount {
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
        List<List<int[]>> adjls = new ArrayList<>();
        for(int i = 0; i <= (2 * n); i++){
            adjls.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            int a = fr.nextInt(), b = fr.nextInt(), c = fr.nextInt();
            adjls.get(a).add(new int[]{b, c});
            adjls.get(a).add(new int[]{n + b, c / 2}); // wow
            adjls.get(n + a).add(new int[]{n + b, c}); // wow
        }
        Comparator<long[]> cmp = new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[1] > o2[1]){
                    return 1;
                }
                if(o1[1] == o2[1]) return 0;
                return -1;
            }
        };
        PriorityQueue<long[]> pq = new PriorityQueue<>(cmp);
        pq.offer(new long[]{1, 0});
        long[] dist = new long[2 * n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        while(!pq.isEmpty()){
            long[] pos = pq.poll();
            int curNode = (int)pos[0];
            long priceToReachNode = pos[1];
            if(priceToReachNode > dist[curNode]){
                continue;
            }
            for(int[] neigh: adjls.get(curNode)){
                long newDistance = dist[curNode] + neigh[1];
                if(newDistance < dist[neigh[0]]){
                    dist[neigh[0]] = newDistance;
                    pq.offer(new long[]{neigh[0], newDistance});
                }
            }
        }
        System.out.println(dist[2 * n]);
    }
}
