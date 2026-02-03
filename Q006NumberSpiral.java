import java.util.Scanner;

public class Q006NumberSpiral {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            long y = sc.nextInt();
            long x = sc.nextInt();
            long ans;
            if(y > x){
                ans = y % 2 == 1 ? (y - 1) * (y - 1) + x : (y - 1) * (y - 1) + 2 * y - x;
            }else{
                ans = x % 2 == 0 ? (x - 1) * (x - 1) + y : (x - 1) * (x - 1) + 2 * x - y;
            }
            System.out.println(ans);
        }
    }
}
