import java.util.Scanner;

public class TwoSets {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sumOfN = ((long) n * (n + 1))/2;
        if(sumOfN % 2 == 0){
            System.out.println("YES");

            long target = sumOfN / 2;
            int[] ans = new int[n + 1];
            int countInSet = 0;
            for(int i = n; i > 0; i --){
                if(target >= i) {
                    ans[i] = 1;
                    target -= i;
                    countInSet++;
                }
            }
            System.out.println(countInSet);
            for(int i = 1; i <= n; i++){
                if(ans[i] == 1){
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            System.out.println(n - countInSet);
            for(int i = 1; i <= n; i++){
                if(ans[i] == 0){
                    System.out.print(i + " ");
                }
            }
        }else{
            System.out.print("NO");
        }
    }

}
