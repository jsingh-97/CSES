import java.util.Scanner;

public class Q018RaabIGame {
    private static void solve(int n, int x, int y){
        if (x == 0 && y == 0){
            System.out.println("YES");
            for(int i = 1; i <= n; i++){
                System.out.print(i + " ");
            }
            System.out.println();
            for(int i = 1; i <= n; i++){
                System.out.print(i + " ");
            }
        }
        else if(x == 0 || y == 0 || x + y > n){
            System.out.println("NO");
        }else{
            System.out.println("YES");
            for(int i = 1; i <= n; i++){
                System.out.print(i + " ");
            }
            System.out.println();
            int draw = n - (x + y);
            for(int i = 1; i <= draw; i++){
                System.out.print(i + " ");
            }
            for(int i = draw + x + 1; i <= n; i++){
                System.out.print(i + " ");
            }
            for(int i = draw + 1; i <= draw + x; i++){
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n, a, b;
            n = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();
            solve(n, a, b);
            t--;
        }
    }
}
