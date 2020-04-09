public class BurstBalloons {

    public static int[][] map;
    public static int maxBurst(int[] num){
        int res = 1;
        if (num.length == 0)
            return 0;
        int[] ar = new int[num.length + 2];
        ar[0] = 1;
        //boolean flag = false;
        ar[ar.length - 1] = 1;
        for (int i = 0; i < num.length; i++){
            ar[i+1] = num[i];
        }
        map = new int[ar.length][ar.length];
        res = balloons(ar, 1, ar.length - 2);
        System.out.println(res);
        return res;
    }
    private static int balloons(int[] ar, int i, int j){
        if (i > j)
            return 0;
        if(map[i][j] != 0)
            return map[i][j];
        int ans = 0;
        for (int k = i; k <= j; k++){
            ans = Math.max(ans, ar[k]*ar[i-1]*ar[j+1] + balloons(ar, i, k - 1) + balloons(ar, k + 1, j));
        }
        map[i][j] = ans;
        return ans;
    }

    public static void main(String[] args){
        int[] num = {3,1,5,8};
        maxBurst(num);
    }
}
