import java.util.Scanner;

public class Q002MissingNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int xor = 0;
        for(int i = 1; i <= n; i++){
            xor = xor ^ i;
        }
        for(int i = 1; i < n; i++){
            int val = sc.nextInt();
            xor = xor ^ val;
        }
        System.out.print(xor);
    }
}
