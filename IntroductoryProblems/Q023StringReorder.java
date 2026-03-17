package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Q023StringReorder {
    private static boolean isPossible(int[] freq, char ch){
        freq[ch - 'A']--;
        int highestFreq = 0;
        int total = 0;
        for(int f: freq){
            highestFreq = Math.max(highestFreq, f);
            total += f;
        }
        freq[ch - 'A']++;
        return highestFreq <= ((total + 1) / 2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
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
            System.out.print(sb);
        }

    }
}
