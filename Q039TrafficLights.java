
import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;
import java.util.TreeSet;


public class Q039TrafficLights {
    static class Segment{
        int start;
        int len;
        public Segment(int s, int l){
            start = s;
            len = l;
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
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int x = fr.nextInt();
        int n = fr.nextInt();
        TreeMap<Integer, Integer> tMap = new TreeMap<>();//len, count
        tMap.put(x, 1);
        StringBuilder sb = new StringBuilder();
        TreeSet<Integer> positions = new TreeSet<>();
        positions.add(0); positions.add(x);
        for(int i = 0; i < n; i++){
            int p = fr.nextInt();
            int prev= positions.lower(p);
            int next = positions.higher(p);
            int prevLen = next - prev;
            int count = tMap.get(prevLen);

            if (count == 1) tMap.remove(prevLen);
            else tMap.put(prevLen, count - 1);

            int leftLen = p - prev;
            int rightLen = next - p;
            tMap.put(leftLen, tMap.getOrDefault(leftLen, 0) + 1);
            tMap.put(rightLen, tMap.getOrDefault(rightLen, 0) + 1);
            positions.add(p);
            sb.append(tMap.lastKey()).append(" ");
        }
        System.out.println(sb);
    }
}

