public class RotateImage {
    public static void rotate(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n/2; i++){
            if(n%2 == 0) {
                for (int j = 0; j < n / 2; j++) {
                    matrix = swap(matrix, i, j);
                    //printMatrix(matrix);
                }
            }else{
                for (int j = 0; j <= n / 2; j++) {
                    matrix = swap(matrix, i, j);
                    //printMatrix(matrix);
                }
            }
        }
        printMatrix(matrix);
    }
    private static int[][] swap(int[][] num, int i, int j){
        int n = num.length - 1;
        int temp = num[i][j];
        num[i][j] = num[n-j][i];
        num[n-j][i] = temp;

        temp = num[n-j][i];
        num[n-j][i] = num[n-i][n-j];
        num[n-i][n-j] = temp;

        temp = num[n-i][n-j];
        num[n-i][n-j] = num[j][n-i];
        num[j][n-i] = temp;
        return num;
    }

    public static void rotateImage(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n/2; i++){
            for(int j = 0; j < Math.ceil(((double) n)/2); j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
        rotate(matrix);                         //90 degree rotation
        System.out.println();
        rotateImage(matrix);                    //180 degree rotation
    }
}
