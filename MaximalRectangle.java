import java.awt.*;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix){
        int res = 0;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        res = getAreaOfRectangle(matrix, 0, 0, 0, 0);
        System.out.println(res);
        return res;
    }
    private static int getAreaOfRectangle(char[][] matrix, int i, int j, int k, int l){
        if(i == matrix.length || j == matrix[0].length)
            return 0;
        else if(i < 0 || j < 0 || i > matrix.length || j > matrix[0].length)
            return 0;
        else {
            return getAreaOfRectangle(matrix, i+1, j, k, l) + Integer.parseInt(""+matrix[i][j]+"");
        }
    }

    public static int maxRectangle(char[][] matrix){
        int res = 0;
        if(matrix == null || matrix.length == 0)
            return 0;
        int row = matrix.length, cols = matrix[0].length;
        int[][] oneAll = new int[row][cols];
        for(int j = 0; j < cols; j++){
            oneAll[0][j] = matrix[0][j] - '0';
        }
        for(int i = 1; i < row; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1')
                    oneAll[i][j] = oneAll[i-1][j] + 1;
                else
                    oneAll[i][j] = 0;
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < cols; j++){
                int max = maxAreaOfRectangle(oneAll[i], j);
                res = Math.max(res, max);
            }
        }
        System.out.println(res);
        return res;
    }
    private static int maxAreaOfRectangle(int[] histogram, int i){
        int current = histogram[i], left = i - 1, right = i+1;
        while (left >= 0){
            if(histogram[left] >+ current)
                left--;
            else
                break;
        }
        while (right < histogram.length){
            if (histogram[right] >= current)
                right++;
            else
                break;
        }
        return current*(right-left-1);
    }

    public static int maximalAreaRectangle(char[][] matrix){
        if(matrix == null || matrix.length == 0) return 0;
        int row = matrix.length, cols = matrix[0].length;
        int[] height = new int[cols+1];
        int[][] width = new int[row+1][cols+1];
        int res = 0;
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= cols; j++){
                if(matrix[i-1][j-1] == '1'){
                    height[j]++;
                    width[i][j] = width[i][j-1] + 1;
                    for(int minWidth = width[i][j], k = 0; k < height[j]; k++){
                        minWidth = Math.min(minWidth, width[i-k][j]);
                        int area = minWidth*(k+1);
                        res = Math.max(res, area);
                    }
                }else
                    height[j] = 0;
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        //maximalRectangle(matrix);
        maxRectangle(matrix);
        maximalAreaRectangle(matrix);
    }
}
