public class UniquePaths {
    public static int uniqueP(int m, int n){
        if(m <= 0 || n <= 0)
            return 0;
        else if(m == 1 || n == 1)
            return 1;
        int path = getAllLegalPath(m - 1 , n - 1, 0, 0);
        System.out.println(path);
        return path;
    }
    private static int getAllLegalPath(int m, int n, int i, int j){
        if(i == m && j == n)
            return 1;
        else if(i > m || j > n)
            return 0;
        else if(i == m)
            return getAllLegalPath(m, n, i, j + 1);
        else if(j == n)
            return getAllLegalPath(m, n, i + 1, j);
        else {
            return getAllLegalPath(m, n, i + 1, j) + getAllLegalPath(m, n, i, j + 1);
        }
    }

    public static int paths(int m, int n){
        if(m == 1 && n == 1)
            return 1;
        else if(m < 1 || n < 1)
            return 0;
        else if(m == 1)
            return paths(m, n - 1);
        else if(n == 1)
            return paths(m - 1, n);
        else
            return paths(m - 1, n) + paths(m, n - 1);
    }

    public static void main(String[] args){
        int m = 3, n = 2;
        uniqueP(m, n);
        int test = paths(m , n);
        System.out.println(test);
    }
}
