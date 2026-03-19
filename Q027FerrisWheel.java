import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q027FerrisWheel {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            try {
                while(st == null || !st.hasMoreElements()){
                    st = new StringTokenizer(br.readLine());
                }
            }catch (IOException exception){
                exception.printStackTrace();
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
    public static void main(String[] args){
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int maxWeight = fr.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = fr.nextInt();
        }
        Arrays.sort(arr);
        int s = 0, e = arr.length - 1;
        int ans = 0;
        while(s <= e){
            if(arr[e] + arr[s] <= maxWeight){
                s++;
            }
            e--;
            ans++;
        }
        System.out.println(ans);
    }
}
