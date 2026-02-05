import java.util.*;

public class Q013GrayCode {
    private static List<String> solve(int n){
        if(n == 1){
            return Arrays.asList("0", "1");
        }
        List<String> ls = new ArrayList<>();
        List<String> ls1 = solve(n - 1);
        List<String> ls2 = new ArrayList<>(ls1);
        Collections.reverse(ls2);
        ls1.stream().map(s-> "0" + s).forEach(ls::add);
        ls2.stream().map(s-> "1" + s).forEach(ls::add);
        return ls;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        solve(n).forEach(System.out::println);
    }
}
