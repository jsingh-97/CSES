import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Q020KnightMovesGrid {
    static int[][] dirs = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
    private static void solve(int[][] m){
        Queue<int[]> q = new ArrayDeque<>();
        int n = m.length;
        q.offer(new int[]{0, 0, 0});
        m[0][0] = 0;
        while(!q.isEmpty()){
            int[] a = q.poll();
            for(int[] dir: dirs){
                int nextX = a[0] + dir[0];
                int nextY = a[1] + dir[1];
                if(nextX >= 0 && nextX < n && nextY >=0 && nextY < n && m[nextX][nextY] == -1){
                    q.offer(new int[]{nextX, nextY, a[2] + 1});
                    m[nextX][nextY] = a[2] + 1;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(mat[i], -1);
        }
        solve(mat);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
