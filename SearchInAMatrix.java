public class SearchInAMatrix {
    public static boolean searchMatrix(int[][] matrix, int t){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int i = 0, j = 0;
        boolean flag = getValueByRecursion(matrix, t, 0, 0);
        System.out.println(flag);
        return flag;
    }
    public static boolean getValueByRecursion(int[][] matrix, int t, int i, int j){
        if(i >= matrix.length || j >= matrix[0].length)
            return false;
        else if(matrix[i][j] > t)
            return false;
        else if(matrix[i][j] == t)
            return true;
        else{
            return (getValueByRecursion(matrix, t, i, j+1) || getValueByRecursion(matrix, t, i+1, j));
        }
    }

    public static boolean searchUsingBinary(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int start = 0, end = matrix.length*matrix[0].length - 1;boolean flag = false;
        while (start <= end){
            int mid = (start + end)/2;
            int mX = mid/matrix[0].length;
            int mY = mid%matrix[0].length;
            if(matrix[mX][mY] == target) {
                flag = true;
                break;
            }
            if(matrix[mX][mY] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        System.out.println(flag);
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 3;
        searchMatrix(matrix, target);
        searchUsingBinary(matrix, target);
    }
}
