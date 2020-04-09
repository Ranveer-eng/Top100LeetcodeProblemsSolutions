public class SubArraySumEqualsSum {
    public static int subArraySum(int[] num, int k){
        int res = 0;int i = 0;
        while (i < num.length){
            if(num[i] < k){
                int ans = num[i];
                for(int j = i + 1; j < num.length; j++){
                    ans += num[j];
                    if(ans == k)
                        res++;
                    if(ans > k)
                        break;
                }
            }
            i++;
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        int[] num = {1,1,1,1};
        int k = 2;
        subArraySum(num, k);
    }
}
