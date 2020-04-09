public class CoinChange {

    public static int minimumCoin(int[] coins, int target, int i) {
        if (target == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < i; j++){
            if(coins[j] <= target){
                int ans = minimumCoin(coins, target - coins[j], i);
                if(ans != Integer.MAX_VALUE && ans + 1 < min)
                    min = ans + 1;
            }
        }
        return min;
    }

    public static void main(String[] args){
        int[] coins = {1,3,5};
        int target = 16;
        int ans = minimumCoin(coins, target, 3);
        System.out.println(ans);
    }
}
