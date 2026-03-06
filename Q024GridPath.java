import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q024GridPath {
    static int ans = 0;
    private static void solve(char[] chs, int idx, int i, int j, boolean[][] vis){
        if(i == 7 && j == 1){
            if(idx == chs.length) ans++;
            return;
        }
        if(idx == chs.length) return;
        //prune the search
        if(vis[i - 1][j] && vis[i + 1][j] && !vis[i][j - 1] &&!vis[i][j + 1]){
            return ;
        }
        if(!vis[i - 1][j] && !vis[i + 1][j] && vis[i][j - 1] && vis[i][j + 1]){
            return ;
        }
        if(chs[idx] == '?' || chs[idx] == 'D'){
            int nextI = i + 1;
            if(!vis[nextI][j]){
                vis[nextI][j] = true;
                solve(chs, idx + 1, nextI, j, vis);
                vis[nextI][j] = false;
            }
        }
        if(chs[idx] == '?' || chs[idx] == 'U'){
            int nextI = i - 1;
            if(!vis[nextI][j]){
                vis[nextI][j] = true;
                solve(chs, idx + 1, nextI, j, vis);
                vis[nextI][j] = false;
            }
        }
        if(chs[idx] == '?' || chs[idx] == 'L'){
            int nextJ = j - 1;
            if(!vis[i][nextJ]){
                vis[i][nextJ] = true;
                solve(chs, idx + 1, i, nextJ, vis);
                vis[i][nextJ] = false;
            }
        }
        if(chs[idx] == '?' || chs[idx] == 'R'){
            int nextJ = j + 1;
            if(!vis[i][nextJ]){
                vis[i][nextJ] = true;
                solve(chs, idx + 1, i, nextJ, vis);
                vis[i][nextJ] = false;
            }
        }
    }

    private static int getPtr(char c) {
        switch (c) {
            case 'D': {
                return 0;
            }
            case 'U' : {
                return 1;
            }
            case 'L' : {
                return 2;
            }
            case 'R' : {
                return 3;
            }
            default : {
                return  -1;
            }
        }
    }

    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        boolean[][] vis = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            vis[0][i] = vis[8][i] = true;
            vis[i][0] = vis[i][8] = true;
        }
        vis[1][1] = true;
        solve(s.toCharArray(), 0, 1, 1, vis);
        System.out.println(ans);
    }
}
