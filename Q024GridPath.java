import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q024GridPath {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Map<Character, Integer> map = new HashMap<>();
    static int ans = 0;

    private static void solve(String s, int idx, int i, int j, boolean[][] vis, int size) {
        if ((i == (size - 1)) && j == 0) {
            if (idx == s.length()) ans++;
            return;
        }
        if (idx == s.length()) return;
        // Corridor split pruning, important and interesting
        if (corridorSplitting(i, j, vis, size)) {
            return;
        }
        if (s.charAt(idx) == '?') {
            for (int[] dir : dirs) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                if (nextI >= 0 && nextI < size && nextJ >= 0 && nextJ < size && !vis[nextI][nextJ]) {
                    vis[nextI][nextJ] = true;
                    solve(s, idx + 1, nextI, nextJ, vis, size);
                    vis[nextI][nextJ] = false;
                }
            }
        } else {
            int k = map.get(s.charAt(idx));
            int nextI = i + dirs[k][0];
            int nextJ = j + dirs[k][1];
            if (nextI >= 0 && nextI < size && nextJ >= 0 && nextJ < size && !vis[nextI][nextJ]) {
                vis[nextI][nextJ] = true;
                solve(s, idx + 1, nextI, nextJ, vis, size);
                vis[nextI][nextJ] = false;
            }
        }
    }

    private static boolean corridorSplitting(int i, int j, boolean[][] vis, int size) {
        // Case 1: Up & Down blocked, Left & Right free
        return ((
                ((i == 0 || vis[i - 1][j]) && (i == size - 1 || vis[i + 1][j])) &&
                        (j > 0 && !vis[i][j - 1]) &&
                        (j < size - 1 && !vis[i][j + 1])
        )
                ||// Case 2: Left & Right blocked, Up & Down free
                (
                        ((j == 0 || vis[i][j - 1]) && (j == size - 1 || vis[i][j + 1])) &&
                                (i > 0 && !vis[i - 1][j]) &&
                                (i < size - 1 && !vis[i + 1][j])
                ));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int size = 7;
        boolean[][] vis = new boolean[size][size];
        map.put('D', 0);
        map.put('U', 1);
        map.put('R', 2);
        map.put('L', 3);
        vis[0][0] = true;
        solve(s, 0, 0, 0, vis, size);
        System.out.print(ans);
    }
}
