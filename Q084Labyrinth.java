import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q084Labyrinth {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static char[] dirsCh = new char[]{'U', 'D', 'R', 'L'};
    public static void main(String[] args) throws IOException {
        //Using BufferedReader because Scanner is too slow for CSES time limits
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] chs = new char[m][n];
        int startI = 0, startJ = 0, endI = 0, endJ = 0;
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                chs[i][j] = s.charAt(j);
                if(chs[i][j] == 'A'){
                    startI = i;
                    startJ = j;
                }
                if(chs[i][j] == 'B'){
                    endI = i;
                    endJ = j;
                }
            }
        }
        boolean[][] vis = new boolean[m][n];
        int[][] path = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startI, startJ});
        boolean solutionFound = false;
        while(!q.isEmpty()){
            int[] node = q.poll();
            if(node[0] == endI && node[1] == endJ){
                solutionFound = true;
                break;
            }
            for(int i = 0; i < dirs.length; i++){
                int[] dir = dirs[i];
                int nextI = node[0] + dir[0];
                int nextJ = node[1] + dir[1];
                if(nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && !vis[nextI][nextJ] && chs[nextI][nextJ] != '#'){
                    vis[nextI][nextJ] = true;
                    path[nextI][nextJ] = i;
                    q.offer(new int[]{nextI, nextJ});
                }
            }
        }
        if(solutionFound){
            System.out.println("YES");
            StringBuilder sb = new StringBuilder();
            while(endI != startI || endJ != startJ){
                sb.append(dirsCh[path[endI][endJ]]);
                if(path[endI][endJ] == 0){
                    endI++;
                }else if(path[endI][endJ] == 1){
                    endI--;
                }else if(path[endI][endJ] == 3){
                    endJ++;
                }else{
                    endJ--;
                }
            }
            System.out.println(sb.length());
            System.out.println(sb.reverse());
        }else{
            System.out.println("NO");
        }
    }
}
