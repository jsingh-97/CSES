import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Q058MovieFestival2 {
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
        int k = fr.nextInt();
        int[][] intervals = new int[n][2];

        for(int i = 0; i < n; i++){
            intervals[i][0] = fr.nextInt();
            intervals[i][1] = fr.nextInt();
        }
        Arrays.sort(intervals, (a, b) -> {
            if(a[1] == b[1]){
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        TreeMap<Integer, Integer> endTimes = new TreeMap<>();
        int moviesWatched = 0;
        int runningMovies = 0;
        for(int i = 0; i < intervals.length; i++){
            Integer prevEndTime = endTimes.floorKey(intervals[i][0]);
            if(prevEndTime != null){
                moviesWatched++;
                endTimes.put(prevEndTime, endTimes.get(prevEndTime) - 1);
                if(endTimes.get(prevEndTime) == 0){
                    endTimes.remove(prevEndTime);
                }
                endTimes.put(intervals[i][1], endTimes.getOrDefault(intervals[i][1], 0) + 1);
            }else if(runningMovies < k){
                moviesWatched++;
                runningMovies++;
                endTimes.put(intervals[i][1], endTimes.getOrDefault(intervals[i][1], 0) + 1);
            }
        }
        System.out.println(moviesWatched);
    }
}
