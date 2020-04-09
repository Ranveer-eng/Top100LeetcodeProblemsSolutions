public class MinimumSquares {
    public static int minimumSq(int n){
        int res = 0;
        if(n < 4)
            return n;
        int m = (int) Math.sqrt(n) + 1;
        res = minSq(n, n);
        System.out.println(res);
        return res;
    }
    private static int minSq(int n, int m){
        if(n == 0)
            return 0;
        else if(n < 1 || m < 1)
            return 2;
        else
            return Math.min(minSq(n - (int)Math.pow(m,2), m), minSq(n - (int)Math.pow(m , 2), m - 1)) + 1;
    }

    public static int miniSq(int n){
        int res = 0;
        int m = (int) Math.sqrt(n) + 1;
        int[] ar = new int[m];
        for(int i = 0; i < m; i++){
            ar[i] = (i+1)*(i+1);
        }
        int i = m - 1, counter = 0;

        return res;
    }

    public static int MathematicallyMinimumSq(int n){
        int m = (int) Math.sqrt(n);
        if(m*m == n)
            return 1;
        int ans = getMin(n);
        System.out.println(ans);
        return ans;
    }
    private static int getMin(int n){
        while ((n & 3) == 0)
            n >>= 2;
        if((n % 7) == 7)
            return 4;
        int m = (int)Math.sqrt(n);
        for(int i = 1; i <= m; i++){
            if((n-i*i) == ((int)Math.sqrt(n-i*i))*((int)Math.sqrt(n-i*i)))
                return 2;
        }
        return 3;
    }

    public static void main(String[] args){
        int n = 48;
        minimumSq(n);
        MathematicallyMinimumSq(n);
    }
}
