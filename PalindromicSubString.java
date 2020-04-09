public class PalindromicSubString {
    public static int palindromeCount(String s){
        if (s.length() <= 1)
            return s.length();
        int ans = 0;
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = 1;
            ans++;
        }
        for (int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                dp[i][i+1] = 1;
                ans++;
            }
        }
        for(int i = 3; i <= s.length(); i++){
            for(int j = 0; j < s.length() - i; j++){
                if(s.charAt(j) == s.charAt(i+j-1) && dp[j+1][i + j -2] == 1){
                    ans++;
                    dp[j][i+j-1] = 1;
                }
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args){
        String s = "abc";
        palindromeCount(s);
    }
}
