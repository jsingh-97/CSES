import java.util.*;

public class Q015CreatingStrings {
    private static void solve(String s, boolean[] vis, StringBuilder sb , Set<String> set){
        if(sb.length() == s.length()){
            set.add(sb.toString());
        }else{
            for(int i = 0; i < s.length(); i++){
                if(!vis[i]){
                    vis[i] = true;
                    sb.append(s.charAt(i));
                    solve(s, vis, sb, set);
                    sb.deleteCharAt(sb.length() - 1);
                    vis[i] = false;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean[] vis = new boolean[s.length()];
        Set<String> ans = new TreeSet<>();
        solve(s, vis, new StringBuilder(), ans);
        System.out.println(ans.size());
        ans.forEach(System.out::println);
    }
}
