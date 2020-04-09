public class ClimbingStairs {
    public static int climb(int n){
        if(n <= 3)
            return n;
        else
            return climb(n-1) + climb(n -2);
    }

    public static int climbStairs(int n){
        int[] ar = new int[n];
        if(n <= 3)
            return n;
        ar[0] = 1; ar[1] = 2;
        for(int i = 2; i < n; i++){
            ar[i] = ar[i-1] + ar[i-2];
        }
        System.out.println(ar[n-1]);
        return ar[n-1];
    }

    public static void main(String[] args){
        int test = climb(6);
        System.out.println(test);
        climbStairs(6);
    }
}
