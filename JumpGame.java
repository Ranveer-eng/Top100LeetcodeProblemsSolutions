public class JumpGame {
    public static int jump(int[] num){
        int res = 0;
        int n = num.length;
        if(n <= 1)
            return n;
        res = minJump(num, 0, 0);
        System.out.println(res);
        return res;
    }
    private static int minJump(int[] num, int i, int p){
        if(i == num.length - 1)
            return p;
        else if(i > num.length - 1)
            return Integer.MAX_VALUE;
        else{
            int ans = Integer.MAX_VALUE;
            for(int j = 1; j <= num[i]; j++){
                if((i+j) <= num.length-1){
                    ans = Math.min(ans, minJump(num, i + j, p+1));
                }
            }
            return ans;
        }
    }

    public static int jumpLeast(int[] num){
        if(num == null || num.length <= 0)
            return 0;
        int lastReach = 0, reach = 0, step = 0;
        for(int i = 0; i <= reach && i < num.length; i++){
            if(i > lastReach){
                step++;
                lastReach = reach;
            }
            reach = Math.max(reach, num[i]+i);
        }
        if(reach < num.length-1)
            return 0;
        System.out.println(step);
        return step;
    }

    public static void main(String[] args){
        int[] nums = {2,3,1,1,4};
        jump(nums);
        jumpLeast(nums);
    }
}
