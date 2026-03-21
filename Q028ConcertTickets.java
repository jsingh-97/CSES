
import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;

public class Q028ConcertTickets {
    // This is to avoid TLE in java
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
            } while (c <= ' ');

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
        int n = fr.nextInt(), m = fr.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++){
            int price = fr.nextInt();
            map.put(price, map.getOrDefault(price, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            int cash = fr.nextInt();
            Integer ticketPriceJustLessThanCash = map.floorKey(cash);
            if(ticketPriceJustLessThanCash != null){
                sb.append(ticketPriceJustLessThanCash).append("\n");
                int count = map.get(ticketPriceJustLessThanCash);
                if(count == 1){
                    map.remove(ticketPriceJustLessThanCash);
                }else{
                    map.put(ticketPriceJustLessThanCash, count - 1);
                }
            }else{
                sb.append("-1\n");
            }
        }
        System.out.println(sb);
    }
}
