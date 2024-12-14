import java.util.Scanner;

public class Permutations {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 2 || n == 3){
            System.out.println("NO SOLUTION");
        }else{
            int counter = 2;
            while(counter <= n){
                System.out.print(counter + " ");
                counter += 2;
            }
            counter  = 1;
            while(counter <= n){
                System.out.print(counter + " ");
                counter += 2;
            }

        }
    }
}
