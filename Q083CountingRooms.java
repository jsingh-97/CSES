import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Q083CountingRooms {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException{
        //Using BufferedReader because Scanner is too slow for CSES time limits
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] chs = new char[m][n];
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                chs[i][j] = s.charAt(j);
            }
        }
        boolean[][] vis = new boolean[m][n];
        int rooms = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(chs[i][j] == '.' && !vis[i][j]){
                    rooms++;
                    bfs(chs, i, j, vis);
                }
            }
        }
        System.out.println(rooms);
    }
    private static void bfs(char[][] chs, int i, int j, boolean[][] vis){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        vis[i][j] = true;
        while (!q.isEmpty()){
            int[] pos = q.poll();
            for(int[] dir: dirs){
                int nextI = pos[0] + dir[0];
                int nextJ = pos[1] + dir[1];
                if(nextI >= 0 && nextI < chs.length && nextJ >= 0 && nextJ < chs[0].length && chs[nextI][nextJ] == '.' && !vis[nextI][nextJ]){
                    q.offer(new int[]{nextI, nextJ});
                    vis[nextI][nextJ] = true;
                }
            }
        }
    }
}
