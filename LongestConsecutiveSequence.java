import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] num){
       if(num == null || num.length == 0)
           return 0;
       int res = 0, max = 1;
       Arrays.sort(num);
       for(int i = 1; i < num.length; i++){
           if(num[i] - num[i-1] == 1){
               max++;
               if(res < max)
                   res = max;
           }else
               max = 1;
       }
        System.out.println(res);
       return res;
    }

    public static int longestConsSequence(int[] num){
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for(int a : num)
            set.add(a);
        for(int a : num){
            int cnt = 1;
            int ans = a - 1;
            int temp = a + 1;
            while (set.contains(ans)){
                set.remove(ans);
                ans--;
                cnt++;
            }
            while (set.contains(temp)){
                set.remove(temp);
                temp++;
                cnt++;
            }
            if(res < cnt)
                res = cnt;
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2, 8,9,10,11,12};
        longestConsecutive(nums);
        longestConsSequence(nums);
    }
}
