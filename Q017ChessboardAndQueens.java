import java.util.Scanner;

public class Q017ChessboardAndQueens {
    private static int solve(String[] sArr, int rIdx, boolean[] col, boolean[] diag1, boolean[] diag2){
        if(rIdx == sArr.length) return 1;
        int ans = 0;
        for(int j = 0; j < 8; j++){
            if(sArr[rIdx].charAt(j) != '*' && !col[j] && !diag1[j - rIdx + sArr.length] && !diag2[rIdx + j]){
                col[j] = true;
                diag1[j - rIdx + sArr.length] = true;
                diag2[rIdx + j] = true;
                ans += solve(sArr, rIdx + 1, col, diag1, diag2);
                col[j] = false;
                diag1[j - rIdx + sArr.length] = false;
                diag2[rIdx + j] = false;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] sArr = new String[8];
        for(int i = 0; i < 8; i++){
            sArr[i] = sc.nextLine();
        }
        boolean[] col = new boolean[8];
        boolean[] diag1 = new boolean[16];
        boolean[] diag2 = new boolean[16];
        System.out.println(solve(sArr, 0, col, diag1, diag2));
    }
}
