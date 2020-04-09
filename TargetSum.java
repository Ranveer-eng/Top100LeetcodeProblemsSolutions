public class TargetSum {
    public static int gettingTarget(int[] num, int target){
        int res = 0;
        res = getThem(num, target, 0);
        System.out.println(res);
        return res;
    }
    private static int getThem(int[] num, int target, int i){
        if(target == 0 && i == num.length)
            return 1;
        else if(target < 0 && i >= num.length || i > num.length - 1)
            return 0;
        else
            return getThem(num, target - num[i], i + 1) + getThem(num, target + num[i], i + 1);
    }

    public static void main(String[] args){
        int[] num = {1,1,1,1,1};
        int target = 3;
        gettingTarget(num, target);
    }
}
