import java.util.Scanner;

public class Q021GridColoringI {
    static char[] options = new char[]{'A', 'B', 'C', 'D'};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] t = sc.nextLine().split(" ");
        int m = Integer.parseInt(t[0]);
        int n = Integer.parseInt(t[1]);
        char[][] chs = new char[m][n];
        for(int i = 0; i < m; i++){
            String s = sc.nextLine();
            for(int k = 0; k < s.length(); k++){
                chs[i][k] = s.charAt(k);
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char ch1 = i > 0 ? chs[i - 1][j]: '.';
                char ch2 = j > 0 ? chs[i][j - 1]: '*';
                for(char ch : options){
                    if(ch != chs[i][j] && ch != ch1 && ch != ch2){
                        chs[i][j] = ch;
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(chs[i][j]);
            }
            System.out.println();
        }


    }
}
