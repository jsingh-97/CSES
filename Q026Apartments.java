import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Q026Apartments {
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
        int m = fr.nextInt();
        int k = fr.nextInt();
        int[] applicants = new int[n];
        for(int i = 0; i < n; i++){
            applicants[i] = fr.nextInt();
        }
        int[] apartments = new int[m];
        for(int i = 0 ; i < m; i++){
            apartments[i] = fr.nextInt();
        }
        int ans = 0;
        Arrays.sort(applicants);
        Arrays.sort(apartments);
        int i = 0, j = 0;
        while(i < n && j < m){
            if(Math.abs(applicants[i] - apartments[j]) <= k){
                ans++;
                i++;
                j++;
            }else if(applicants[i] > apartments[j]){
                j++;
            }else{
                i++;
            }
        }
        System.out.println(ans);
    }
}
