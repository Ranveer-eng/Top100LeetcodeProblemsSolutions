import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int findLIS(int[] num){
        int res = 0;
        for(int i = 0; i < num.length-1; i++) {
            int current = num[i], pointer = 1;
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < current)
                    continue;
                else {
                    pointer++;
                    current = num[j];
                }
            }
            if (pointer > res)
                res = pointer;
        }
        System.out.println(res);
        return res;
    }

    public static int LIS(int[] num){
        int[] ans = new int[num.length];
        int res = 0;
        for(int x : num){
            int i = 0, j = res;
            while (i != j){
                int m = (i+j)/2;
                if(ans[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            ans[i] = x;
            if(i == res)
                res++;
        }
        System.out.println(res);
        return res;
    }

    public static int lengthLIS(int[] num){
        int[] dp = new int[num.length];
        int len = 0;
        for(int a : num){
            int i = Arrays.binarySearch(dp, 0, len, a);
            if(i < 0)
                i = -(i + 1);
            dp[i] = a;
            if(i == len)
                len++;
        }
        System.out.println(len);
        return len;
    }

    public static void main(String[] args){
        int[] num = {10,9,2,5,3,7,101,18};
        findLIS(num);
        LIS(num);
        lengthLIS(num);
    }
}
