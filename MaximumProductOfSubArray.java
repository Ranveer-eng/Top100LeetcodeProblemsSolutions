public class MaximumProductOfSubArray {
    public static int maxPro(int[] num) {
        int res = 0;
        if (num.length == 0)
            return -1;
        for (int i = 0; i < num.length; i++) {
            int max = 1;
            for (int j = i; j < num.length; j++) {
                max *= num[j];
                if (res < max)
                    res = max;
            }
        }
        System.out.println(res);
        return res;
    }

    public static int maximumProduct(int[] num){
        int res = num[0];
        if(num.length == 0)
            return -1;
        int[] max = new int[num.length];
        int[] min = new int[num.length];
        max[0] = min[0] = num[0];
        for(int i = 1; i < num.length; i++){
            if(num[i] > 0){
                max[i] = Math.max(num[i], max[i-1]*num[i]);
                min[i] = Math.min(num[i], min[i-1]*num[i]);
            }else {
                max[i] = Math.max(num[i], min[i-1]*num[i]);
                min[i] = Math.min(num[i], max[i-1]*num[i]);
            }
            res = Math.max(res, max[i]);
        }
        System.out.println(res);
        return res;
    }

    public static int maximumPro(int[] num){
        int res = 1;
        int i = 0, area = 0;
        while (i <= num.length - 1){
            area = area*num[i];
            if(area >= res) {
                res = area;
                i++;
            }else if(num[i] <= 0){
                area = 1;
                i++;
            }
            else if(area < res){
                i++;
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        int[] num = {-1,0,1,2,5,-1,7};
        maxPro(num);
        maximumProduct(num);
        maximumPro(num);
    }
}
