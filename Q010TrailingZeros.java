import java.util.Scanner;

public class Q010TrailingZeros {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int counter = 0;
        for(int i = 0; i <= n; i += 5){
            int j = i;
            while(j > 0 && j % 5 == 0){
                counter++;
                j = j / 5;
            }
        }
        System.out.println(counter);
    }
}
