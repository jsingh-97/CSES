import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

public class Q044NestedRangesCheck {
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
        int[][] ranges = new int[n][3];
        for(int i = 0; i < n; i++){
            ranges[i][0] = fr.nextInt();
            ranges[i][1] = fr.nextInt();
            ranges[i][2] = i;
        }
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o2[0] - o1[0];
                }
                return o1[1] - o2[1];
            }
        });
        boolean[] contains = new boolean[n];
        int maxStartPoint = 0;
        for (int[] range : ranges) {
            if (maxStartPoint >= range[0]) {
                contains[range[2]] = true;
            }
            maxStartPoint = Math.max(maxStartPoint, range[0]);
        }
        boolean[] containedBy = new boolean[n];
        int minStartPoint = Integer.MAX_VALUE;
        for(int i = ranges.length - 1; i >= 0; i--){
            if(minStartPoint <= ranges[i][0]){
                containedBy[ranges[i][2]] = true;
            }
            minStartPoint = Math.min(minStartPoint, ranges[i][0]);
        }
        StringBuilder sb1 = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb1.append(contains[i] ? "1" : "0").append(" ");
        }
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb2.append(containedBy[i] ? "1" : "0").append(" ");
        }
        System.out.println(sb1);
        System.out.println(sb2);
    }
}
