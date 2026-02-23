import java.util.Scanner;

public class Q007TwoKnights {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            long ans;
            long totalSquares = (long) i * i;
            long totalWays = (totalSquares * (totalSquares - 1)) / 2;
            long twoIntoThreeBlocks = (long) (i - 1) * (i - 2);
            long threeIntoTwoBlocks = twoIntoThreeBlocks;
            //each 2 * 3 and 3 * 2 block has 2 positions where knights attack each other
            ans = totalWays - 2 * (twoIntoThreeBlocks + threeIntoTwoBlocks);
            System.out.println(ans);
        }
    }
}
