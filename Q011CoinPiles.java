import java.util.Scanner;

public class Q011CoinPiles {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(valid(a, b)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static boolean valid(long a, long b) {
        //assuming X and Y operations are performed to empty the array then
        // a = X + 2Y, b = 2X + Y
        return (2*b - a > 0 && (2*b - a) % 3 == 0 && 2*a - b > 0 && (2*a - b) % 3 == 0);
    }
}
