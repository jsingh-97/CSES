import java.util.Scanner;

public class Q012PalindromeReorder {
    private static String solve(String s, int oddFreqIdx, int[] freq){
        char[] chs = new char[s.length()];
        int ptr1 = 0, ptr2=s.length()-1;
        for(int i=0; i<26; i++){
            if(freq[i]>0) {
                if (i != oddFreqIdx) {
                    int counter = freq[i] / 2;
                    while (counter > 0) {
                        chs[ptr1] = (char) (i + 65);
                        chs[ptr2] = (char) (i + 65);
                        ptr1++;
                        ptr2--;
                        counter--;
                    }
                }
            }
        }
        if(oddFreqIdx!=-1){
            int counter = freq[oddFreqIdx];
            while(counter>0){
                chs[ptr1] = (char)(oddFreqIdx+65);
                ptr1++;
                counter--;
            }
        }
        return  new String(chs);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)-65]++;
        }
        int oddFreqIdx = -1;
        boolean isPossible = true;
        for(int i = 0; i < 26; i++){
            if(freq[i]%2==1){
                if(oddFreqIdx!=-1){
                    isPossible = false;
                    break;
                }
                oddFreqIdx = i;
            }
        }
        if(!isPossible){
            System.out.println("NO SOLUTION");
        }else{
            System.out.println(solve(s, oddFreqIdx, freq));
        }
    }
}
