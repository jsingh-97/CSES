import java.util.Scanner;

public class Q014TowerOfHanoi {
    private static int solve(int n){
        if(n == 1) return 1;
        int val = solve(n - 1);
        return 2 * val + 1;
    }
    private static void print(int n, int src, int mid, int dest){
        if(n == 1){
            System.out.println(src +" " + dest);
        }else{
            print(n - 1, src, dest, mid);
            print(1, src, mid, dest);
            print(n - 1, mid, src, dest);
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int moves = solve(n);
        System.out.println(moves);
        print(n, 1, 2, 3);
    }
}
