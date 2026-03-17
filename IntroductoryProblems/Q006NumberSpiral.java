package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006NumberSpiral {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            String[] parts = br.readLine().split(" ");
            long r = Long.parseLong(parts[0]);
            long c = Long.parseLong(parts[1]);
            long ans;
            if(r > c){
                long base = (r - 1) * (r - 1);
                ans = r % 2 == 1 ? base + c : base + 2 * r - c;
            }else{
                long base = (c - 1) * (c - 1);
                ans = c % 2 == 0 ? base + r : base + 2 * c - r;
            }
            sb.append(ans +"\n");
        }
        System.out.println(sb);
    }
}
