import java.util.Scanner;

public class Q003Repetitions {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int runningCount = 1;
        int maxCount = 1;
        for(int i = 1; i < str.length(); i++){
            runningCount = str.charAt(i) == str.charAt(i - 1) ? runningCount + 1 : 1;
            maxCount = Math.max(maxCount, runningCount);
        }
        System.out.println(maxCount);
    }
}
