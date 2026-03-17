package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q011CoinPiles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t > 0){
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            if(valid(a, b)){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
            t--;
        }
        System.out.println(sb);
    }

    private static boolean valid(long a, long b) {
        //assuming X and Y operations are performed to empty the array then
        // a = X + 2Y, b = 2X + Y
        return ((2*b - a) >= 0 && (2*b - a) % 3 == 0 && (2*a - b) >= 0 && (2*a - b) % 3 == 0);
    }
}
