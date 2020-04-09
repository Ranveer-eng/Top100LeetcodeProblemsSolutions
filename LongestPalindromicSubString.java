public class LongestPalindromicSubString {
    static String longestPalindrome(String s){
        int max = 0, i = 0, j = 0;
        String res = "";
        int n = s.length();
        if(n <= 1){
            return s;
        }
        for(i = 0; i < n; i++){
            for(j = i;j < n; j++){
                String st = s.substring(i,j+1);
                if(max < st.length()){
                    boolean flag = true;
                    for(int k = 0; k < st.length(); k++){
                        if(st.charAt(k) != st.charAt(st.length() - k-1)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        res = st;
                        max = st.length();
                    }
                }
            }
        }
        System.out.println(res);
        return res;
    }

    public static String longestPalindromicSub(String s){
        int n = s.length();
        if(n <= 1){
            return s;
        }
        char[] ar = new char[2*n + 1];
        for(int i = n-1; i >= 0; i--){
            ar[2*i + 1] = s.charAt(i);
            ar[2*i] = '#';
        }
        ar[2*n] = '#';
        final int arLength = 2*n;
        int[] lps = new int[arLength + 1];
        int p = 0;
        for(int i = 0; i <= arLength; i++){
            lps[i] = 0;
            if(lps[p] + p >= i){
                lps[i] = Math.min(lps[2*p - i], p + lps[p] - i);
            }
            while (i + lps[i] + 1 <= arLength && i - lps[i] - 1 >= 0 && ar[i + lps[i] + 1] == ar[i - lps[i] - 1])
                lps[i]++;
            if(p + lps[p] < i + lps[i])
                p = i;
        }
        int i = 0, j = 0;
        for(int k = 0; k < arLength; k++){
            if(i < lps[k]){
                i = lps[k];
                j = k;
            }
        }
        if(j%2 == 0){
            return s.substring(j/2 - i/2, j/2 + i/2);
        }else{
            return s.substring(j/2 - i/2, j/2 + i/2 + 1);
        }
    }

    public static String longestPalindromeSub(String s){
        int n = s.length();
        if(s == null || n <= 1){
            return s;
        }
        String res = "";
        int start = 0, end = 0;
        for(int i = 0; i < n; i++){
            int length = Math.max(getLength(s,i,i), getLength(s,i,i+1));
            if(length > end - start){
                start = i - (length - 1)/2;
                end = i + length/2;
            }
        }
        res = s.substring(start, end + 1);
        System.out.println(res);
        return res;
    }
    private static int getLength(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static String longestPalindromeSubString(String s){
        if(s == null || s.length() <= 1){
            return s;
        }
        int n = s.length();
        int max = 1;
        boolean[][] dp = new boolean[n][n];
        String res = "";
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i; j++){
                if(s.charAt(j) == s.charAt(i + j) && (i <= 2 || dp[j+1][j+i-1])){
                    dp[j][i+j] = true;
                    if(i > max - 1){
                        max = i + 1;
                        res = s.substring(j, i + j + 1);
                    }
                }
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        longestPalindrome("babad");                      //Brute Force  O(n^3)
        String s = longestPalindromicSub("babad");       //Manacher's Algorithm
        System.out.println(s);
        longestPalindromeSub("babad");                   //Simple Algorithm
        longestPalindromeSubString("babad");             //Dynamic Programming
        //longestPalindromeUsingHash("babad");
    }
}
