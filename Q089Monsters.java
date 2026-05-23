import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q089Monsters {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static char[] dirsCh = new char[]{'U', 'D', 'R', 'L'};
    public static void main(String[] args) throws IOException {
        //Using BufferedReader because Scanner is too slow for CSES time limits
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] chs = new char[m][n];
        ArrayDeque<int[]> monsters = new ArrayDeque<>();
        int[][] m_dist = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(m_dist[i], Integer.MAX_VALUE);
        }
        int srcI = -1, srcJ = -1;

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                chs[i][j] = s.charAt(j);
                if(chs[i][j] == 'M') {
                    monsters.offer(new int[]{i, j});
                    m_dist[i][j] = 0;
                }else if(chs[i][j] == 'A'){
                    srcI = i;
                    srcJ = j;
                }
            }
        }

        while(!monsters.isEmpty()){
            int[] monsterPos = monsters.poll();
            int i = monsterPos[0], j = monsterPos[1];
            for(int[] dir: dirs){
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                if(nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && chs[nextI][nextJ] != '#' && m_dist[i][j] + 1 < m_dist[nextI][nextJ]){
                    m_dist[nextI][nextJ] = m_dist[i][j] + 1;
                    monsters.offer(new int[]{nextI, nextJ});
                }
            }
        }


        char[][] path = new char[m][n];
        boolean isPossible = false;
        boolean[][] vis = new boolean[m][n];
        ArrayDeque<int[]> q = new ArrayDeque<>(); // i, j, distance from a
        q.offer(new int[]{srcI, srcJ, 0});
        vis[srcI][srcJ] = true;
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int i = arr[0], j = arr[1], curdist = arr[2];
            if(i == 0 || j == 0 || i == (m - 1) || (j == n - 1)){
                isPossible = true;
                printPath(i, j, path, srcI, srcJ);
                break;
            }
            for(int k = 0; k < dirs.length; k++){
                int[] dir = dirs[k];
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                int nextDist = curdist + 1;
                if(nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && !vis[nextI][nextJ] && chs[nextI][nextJ] != '#' && nextDist < m_dist[nextI][nextJ]){
                    vis[nextI][nextJ] = true;
                    path[nextI][nextJ] = dirsCh[k];
                    q.offer(new int[]{nextI, nextJ ,nextDist});
                }
            }
        }
        if(!isPossible){
            System.out.println("NO");
        }
    }
    private static  void printPath(int destI, int destJ, char[][] path, int srcI, int srcJ){
        System.out.println("YES");
        // Using StringBuilder instead of list solved TLE
        StringBuilder sb = new StringBuilder();
        while(destI != srcI || destJ != srcJ){
            sb.append(path[destI][destJ]);
            switch (path[destI][destJ]) {
                case 'L':
                    destJ++;
                    break;
                case 'R':
                    destJ--;
                    break;
                case 'U':
                    destI++;
                    break;
                default:
                    destI--;
                    break;
            }
        }
        System.out.println(sb.length());
        System.out.println(sb.reverse());
    }
}
