import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
           arr[i] = sc.nextInt();
        }
        long movesRequired = 0;
        for(int i = 1; i < arr.length; i++){
            movesRequired += Math.max(0, arr[i - 1] - arr[i]);
            if(arr[i] < arr[i - 1]){
                arr[i] = arr[i - 1];
            }
        }
        System.out.print(movesRequired);
    }
}
