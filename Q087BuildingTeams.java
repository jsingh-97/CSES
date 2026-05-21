import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Q087BuildingTeams {
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
        List<List<Integer>> adjls = new ArrayList<>();
        for(int i = 0; i < m; i++){
            adjls.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            int a = fr.nextInt() - 1;
            int b = fr.nextInt() - 1;
            adjls.get(a).add(b);
            adjls.get(b).add(a);
        }
        int[] colors = new int[m];
        boolean isPossible = true;
        for(int i = 0; i < m; i++){
            if(colors[i] == 0){
                // lets color it
                if(dfs(i, adjls, colors, 1)){
                    continue;
                }else{
                    isPossible = false;
                    System.out.println("IMPOSSIBLE");
                    break;
                }
            }
        }
        if(isPossible){
            for(int i = 0; i < colors.length; i++){
                System.out.print((colors[i] < 0 ? 2 : 1) +" ");
            }
        }

    }
    private static boolean dfs(int node, List<List<Integer>> adjls, int[] colors, int curColor){
        if(colors[node] != 0){
            return colors[node] == curColor;
        }
        colors[node] = curColor;
        for(int neigh: adjls.get(node)){
            if(dfs(neigh, adjls, colors, -curColor)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}
