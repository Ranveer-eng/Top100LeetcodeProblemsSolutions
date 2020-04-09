public class MaximalSquare {
    public static int maxSquare(char[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int res = 0;
        int[] ar = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            ar[i] = (numOfConsecutiveOne(matrix[i]));
        }
        for(int i = 0; i < ar.length ; i++){
            int min = ar[i];
            for(int j=i+1 ; j < ar.length; j++){
                if(ar[j] < min)
                    min = ar[j];
                int area = Math.min(min,(j-i+1))*Math.min(min, (j-i+1));
                if(area > res)
                    res = area;
            }
        }
        System.out.println(res);
        return res;
    }
    private static int numOfConsecutiveOne(char[] ar){
        int ans = 0;
        int i = 0;
        for(int j = 0; j < ar.length; j++){
            if(j != 0 && ar[j-1] != '1')
                i = 0;
            if(ar[j] == '1'){
                i++;
                if(j < ar.length - 1 && ar[j+1] == '1'){
                    i++;
                    j++;
                }else {
                    j++;
                }
                if(ans < i)
                    ans = i;
            }
        }
        return ans;
    }

    public static int maximalSquareUsingDP(char[][] matrix){
        if(matrix == null || matrix.length == 0)
            return 0;
        int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            dp[i][0] = matrix[i][0] - '0';
            res = Math.max(res, dp[i][0]);
        }
        for(int i = 0; i < matrix[0].length; i++){
            dp[0][i] = matrix[0][i] - '0';
            res = Math.max(res, dp[0][i]);
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    int minimum = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                    dp[i][j] = minimum + 1;
                    res = Math.max(res, minimum+1);
                }else
                    dp[i][j] = 0;
            }
        }
        int ans = res*res;
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args){
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        maxSquare(matrix);
        maximalSquareUsingDP(matrix);
    }
}
