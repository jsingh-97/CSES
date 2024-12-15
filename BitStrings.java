import java.util.Scanner;

public class BitStrings {
    static int mod = 1000000007;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(calc(n));
    }
    private static long calc(int n){
        if(n == 1) return 2;
        long a = calc(n /2);
        if(n % 2 == 0){
            return (a * a) % mod;
        }else{
            return ((a * a) % mod * 2 ) % mod;
        }
    }
}
