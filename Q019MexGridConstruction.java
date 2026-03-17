import java.util.Scanner;

public class Q019MexGridConstruction {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        for(int row = 0; row < n; row++){
            boolean[] vis1 = new boolean[2 * n + 1];
            for(int col = 0; col < n; col++){
                boolean[] vis2 = new boolean[2 * n + 1];
                for(int x = 0; x < row; x++){
                    vis2[mat[x][col]] = true;
                }
                int counter = 0;
                while(vis2[counter] || vis1[counter]){
                    counter++;
                }
                mat[row][col] = counter;
                vis1[counter] = true;
                System.out.print(counter +" ");
            }
            System.out.println();
        }
    }
}
