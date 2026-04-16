import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JosephusProblemI {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            q.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            q.offer(q.poll());
            sb.append(q.poll()).append(" ");
        }
        System.out.println(sb);
    }
}
