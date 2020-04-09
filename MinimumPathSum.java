public class MinimumPathSum {
    public static int minPathSum(int[][] grid){
        int res = 0;
        res = getMinSum(grid, 0, 0);
        System.out.println(res);
        return res;
    }
    private static int getMinSum(int[][] grid, int i, int j){
        if(i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];
        else if(i > grid.length - 1 || j > grid[0].length - 1)
            return 0;
        else if(i == grid.length - 1)
            return getMinSum(grid, i, j + 1) + grid[i][j];
        else if(j == grid[0].length - 1)
            return getMinSum(grid, i + 1, j) + grid[i][j];
        else {
            return Math.min(getMinSum(grid, i, j + 1) , getMinSum(grid, i + 1, j)) + grid[i][j];
        }
    }

    public static int minPathSUm(int[][] grid){
        if(grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for(int i= 1; i < n; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for(int j = 1; j < m; j++){
            dp[j][0] = dp[j-1][0] + grid[j][0];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(dp[i-1][j] > dp[i][j-1])
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                else
                    dp[i][j] = dp[i-1][j] + grid[i][j];
            }
        }
        System.out.println(dp[m-1][n-1]);
        return dp[m-1][n-1];
    }

    public static void main(String[] args){
        int[][] grid = {{1,3,3},{1,5,1},{4,2,1}};
        minPathSum(grid);                                                   //Simple Recursion
        minPathSUm(grid);                                                   //Dynamic Programming
    }
}
