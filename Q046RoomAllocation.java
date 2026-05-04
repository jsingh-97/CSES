import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q046RoomAllocation {
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
        int[][] times = new int[n][3];
        for(int i = 0; i < n; i++){
            int arrival = fr.nextInt();
            int departure = fr.nextInt();
            times[i][0] = arrival;
            times[i][1] = departure;
            times[i][2] = i;
        }
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        //[end time, roomId]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]- b[0]);
        int availableRoomNumber = 1;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            if(pq.isEmpty() || pq.peek()[0] >= times[i][0]){
                ans[times[i][2]] = availableRoomNumber;
                pq.offer(new int[]{times[i][1], availableRoomNumber++});
            }else{
                int[] arr = pq.poll();
                ans[times[i][2]] = arr[1];
                arr[0] = times[i][1];
                pq.offer(arr);
            }
        }
        System.out.println(availableRoomNumber - 1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}
