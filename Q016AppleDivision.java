import java.util.Scanner;


public class Q016AppleDivision {
    static long  ans = Long.MAX_VALUE;
    private static void solve(int[] nums, int idx, long cursum, long totalSum){
        if(idx == nums.length){
            ans = Math.min(ans, Math.abs(cursum - (totalSum - cursum)));
        }else{
            solve(nums, idx + 1, cursum, totalSum);
            solve(nums, idx + 1, cursum + nums[idx], totalSum);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        long totalSum = 0;
        for(int i = 0; i  < n; i++){
            nums[i] = sc.nextInt();
            totalSum += nums[i];
        }
        solve(nums, 0, 0, totalSum);
        System.out.println(ans);
    }
}
