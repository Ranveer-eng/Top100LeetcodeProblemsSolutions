public class HouseRobber {
    public static int robbing(int[] num){
        if(num.length == 1)
            return num[0];
        int res = robbed(num, 0, -2);
        System.out.println(res);
        return res;
    }
    private static int robbed(int[] num, int i, int j){
        if(i == num.length)
            return 0;
        else if(i > num.length)
            return 0;
        else{
            if(i != j+1)
                return Math.max(robbed(num, i+1, j), robbed(num, i + 1, i) + num[i]);
            else
                return robbed(num, i + 1, j);
        }
    }

    public static int rob(int[] num){
        if(num == null || num.length == 0)
            return 0;
        if(num.length == 1)
            return num[0];
        int[] dp = new int[num.length];
        dp[0] = num[0];
        dp[1] = Math.max(num[0], num[1]);
        for(int i = 2; i < num.length; i++){
            dp[i] = Math.max(dp[i-2]+num[i], dp[i-1]);
        }
        int res = dp[num.length - 1];
        System.out.println(res);
        return res;
    }

    public static int robb(int[] num){
        if(num == null || num.length == 0)
            return 0;
        int even = 0, odd = 0;
        for(int i = 0; i < num.length; i++){
            if(i%2 == 0){
                even += num[i];
                even = even > odd ? even : odd;
            }else {
                odd += num[i];
                odd = even > odd ? even : odd;
            }
        }
        int res = even > odd ? even : odd;
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        int[] num = {1,2,3,1,9,22,23};
        robbing(num);
        rob(num);
        robb(num);
    }
}
