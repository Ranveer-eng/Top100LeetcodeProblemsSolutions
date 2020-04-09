public class NumberOfIslands {
    public static int numOfIsland(char[][] grid){
        if(grid == null || grid.length == 0)
            return 0;
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    makePositive(grid, i, j);
                    res++;
                }
            }
        }
        System.out.println(res);
        return res;
    }
    private static void makePositive(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1')
            return;
        grid[i][j] = '+';
        int[][] allDirections = {{0,1},{0,-1},{-1,0},{1,0}};
        for(int[] d : allDirections){
            makePositive(grid, i + d[0], j + d[1]);
        }
    }

    public static int[][] matrix;
    public static int mark = 1;
    public static int numIsLands(char[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        matrix = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length ; i++){
            for(int j = 0; j < grid[0].length; j++){
                mark = mark(i, j, grid) ? (mark+1) : mark;
            }
        }
        int res = mark - 1;
        System.out.println(res);
        return res;
    }
    private static boolean mark(int i, int j, char[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            if(matrix[i][j] == 0 && grid[i][j] == '1'){
                matrix[i][j] = mark;
                mark(i-1, j, grid);
                mark(i+1, j, grid);
                mark(i, j-1, grid);
                mark(i, j+1, grid);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        numOfIsland(grid);
        numIsLands(grid);
    }
}
