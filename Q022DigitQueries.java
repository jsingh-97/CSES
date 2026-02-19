
import java.util.Scanner;

public class Q022DigitQueries {
    private static void solve(long n){
        if(n < 10){
            System.out.println(n);
            return;
        }
        long base = 9, digits = 1;
        while(n - base * digits > 0){
            n = n - base * digits;
            base *= 10;
            digits++;
        }
        long start = (long)Math.pow(10, digits - 1);
        long numPos = (n - 1)/ digits;
        long numberAtNthDigit = start + numPos;
         n = n - digits * numPos;
        String s = String.valueOf(numberAtNthDigit);
        System.out.println(s.charAt((int)n - 1));
    }
    public static  void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for(int i = 0; i < q; i++){
            long k = sc.nextLong();
            solve(k);
        }
    }
}
