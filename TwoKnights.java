import java.util.Scanner;

public class TwoKnights {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            long ans;
            long totalSquares = (long) i * i;
            long totalWays = totalSquares * (totalSquares - 1);
            long twoXThreeBlocks = (long) (i - 1) * (i - 2);
            long threeXTwoBlocks = twoXThreeBlocks;
            //each 2 * 3 and 3 * 2 block has 2 positions where knights attack each other
            ans = totalWays /2 - (2 * twoXThreeBlocks + 2 * threeXTwoBlocks);

            System.out.println(ans);
        }
    }
}
