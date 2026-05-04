import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Q045NestedRangesCount {
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
    static class Range {
        int l, r, idx;
        Range(int l, int r, int idx) {
            this.l = l;
            this.r = r;
            this.idx = idx;
        }
    }

    static class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int i, int delta) {
            while (i <= n) {
                tree[i] += delta;
                i += i & -i;
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();

        Range[] ranges = new Range[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            int l = fr.nextInt();
            int r = fr.nextInt();
            ranges[i] = new Range(l, r, i);
            ends[i] = r;
        }

        // coordinate compression
        Arrays.sort(ends);
        Map<Integer, Integer> compress = new HashMap<>();
        int id = 1;
        for (int x : ends) {
            if (!compress.containsKey(x)) {
                compress.put(x, id++);
            }
        }

        // sort ranges
        Arrays.sort(ranges, (a, b) -> {
            if (a.l == b.l) return b.r - a.r;
            return a.l - b.l;
        });

        int[] contains = new int[n];
        int[] contained = new int[n];

        // --------- contained by ---------
        Fenwick fenwick = new Fenwick(n);

        for (int i = 0; i < n; i++) {
            int rIdx = compress.get(ranges[i].r);

            int total = fenwick.query(n);
            int strictlySmaller = fenwick.query(rIdx - 1);
            contained[ranges[i].idx] = total - strictlySmaller;

            fenwick.update(rIdx, 1);
        }

        // reset fenwick
        fenwick = new Fenwick(n);

        // --------- contains ---------
        for (int i = n - 1; i >= 0; i--) {
            int rIdx = compress.get(ranges[i].r);

            contains[ranges[i].idx] = fenwick.query(rIdx);

            fenwick.update(rIdx, 1);
        }

        // output
        for (int x : contains) System.out.print(x + " ");
        System.out.println();
        for (int x : contained) System.out.print(x + " ");
    }
}
