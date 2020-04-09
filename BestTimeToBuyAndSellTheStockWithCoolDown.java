public class BestTimeToBuyAndSellTheStockWithCoolDown {
    public static int sellAndBuy(int[] num){
        int res = money(num, 0, false, 0);
        System.out.println(res);
        return res;
    }
    private static int money(int[] num, int i, boolean buy, int bought){
        if(i == num.length)
            return 0;
        if(i > num.length)
            return 0;
        else {
            if(buy)
                return Math.max(num[i] - bought + money(num, i + 1, false, 0), 0);
            else
                return Math.max(money(num, i + 1, buy, bought), money(num, i + 1, true, num[i]));
        }
    }

    public static int sellMoney(int[] num){
        if(num == null || num.length <= 0)
            return 0;
        boolean buy = false, sell = false, cooldown = true;
        int ans = 0, bought = 0;
        for(int i = 0; i < num.length; i++){
            if (cooldown){
                bought = num[i];
                buy = true;
            }
            if(sell){
                cooldown = true;
            }
            if(buy) {
                ans = num[i] - bought;
                sell = true;
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args){
        int[] num = {1,2,3,0,2};
        sellAndBuy(num);
        sellMoney(num);
    }
}
