public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices){
        int res = 0, min = prices[0];
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else{
                int ans = prices[i] - min;
                if(res < ans)
                    res = ans;
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        int[] prices = {7,1,7,5,3,6,4};
        int[] price = {7,6,5,4,3,2,1};
        maxProfit(prices);
    }
}
