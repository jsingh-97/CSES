import java.util.Scanner;
import java.lang.*;
public class Q023StringReorder {
    private static boolean isPossible(int[] freq, char ch){
        freq[ch - 'A']--;
        int highestFreq = 0;
        int total = 0;
        for(int i = 0; i < freq.length; i++){
            highestFreq = Math.max(highestFreq, freq[i]);
            total += freq[i];
        }
        freq[ch - 'A']++;
        return highestFreq <= ((total + 1) / 2);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch - 'A']++;
        }
        StringBuilder sb = new StringBuilder();
        boolean answerPossible = true;
        for(int i = 0; i < s.length(); i++){
            boolean flag = false;
            for(char ch = 'A'; ch <= 'Z'; ch++){
                if((sb.length() == 0 || sb.charAt(sb.length() - 1) != ch) && freq[ch - 'A'] != 0 && isPossible(freq, ch)){
                    freq[ch - 'A']--;
                    sb.append(ch);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                answerPossible = false;
                break;
            }
        }
        if(!answerPossible){
            System.out.println(-1);
        }else{
            for(int i = 0; i < sb.length(); i++){
                System.out.print(sb.charAt(i));
            }
        }

    }
}
