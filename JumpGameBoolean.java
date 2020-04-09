public class JumpGameBoolean {


    public static boolean jumpToReachEnd(int[] num){
        boolean res = true;
        int n = num.length;
        res = canReach(num, 0);
        System.out.println(res);
        return res;
    }
    private static boolean canReach(int[] num, int index){
        if(index == num.length)
            return true;
        else if(num[index] == 0 || index >= num.length)
            return false;
        else{
            boolean ans = false;
            for(int i = 1; i <= num[index]; i++){
                ans = canReach(num, index + i);
                if(ans)
                    break;
            }
            return ans;
        }
    }

    public static void main(String[] args){
        int[] num = {3,1,-1,4};
        jumpToReachEnd(num);
    }
}
