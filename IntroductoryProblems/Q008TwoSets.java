package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q008TwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sumOfN = ((long) n * (n + 1))/2;
        if(sumOfN % 2 == 0){
            StringBuilder sb1 = new StringBuilder();
            int[] ans = new int[n + 1];
            long target = sumOfN / 2;
            int countInSet = 0;
            for(int i = n; i > 0; i --){
                if(target >= i) {
                    sb1.append(i).append(" ");
                    ans[i] = 1;
                    target -= i;
                    countInSet++;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            for(int i = 1; i <= n; i++){
                if(ans[i] == 0){
                    sb2.append(i).append(" ");
                }
            }
            System.out.println("YES");
            System.out.println(countInSet);
            System.out.println(sb1);
            System.out.println(n - countInSet);
            System.out.println(sb2);
        }else{
            System.out.print("NO");
        }
    }

}
