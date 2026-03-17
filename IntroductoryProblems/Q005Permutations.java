package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q005Permutations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 2 || n == 3){
            System.out.println("NO SOLUTION");
        }else{
            int counter = 2;
            StringBuilder sb = new StringBuilder();
            while(counter <= n){
                sb.append(counter).append(" ");
                counter += 2;
            }
            counter  = 1;
            while(counter <= n){
                sb.append(counter).append(" ");
                counter += 2;
            }
            System.out.print(sb);
        }
    }
}
