import com.sun.javafx.collections.ListListenerHelper;

import java.awt.*;
import java.util.*;
import java.util.List;

public class ThreeSum {
    public static void printList(int[][] list, int p){
        for(int i = 0; i <= p; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static boolean searchMe(int[][] res, int first, int second){
        boolean ans = false;
        for(int i = 0; i < res.length; i++){
            if(res[i][0] == first && res[i][1] == second){
                return true;
            }
        }
        return ans;
    }

    public static int[][] zeroSum(int[] nums){
        int n = nums.length, p = 0;
        int[][] res = new int[n][3];
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    if((nums[i] + nums[j] + nums[k]) == 0){
                        int[] ans = {nums[i], nums[j], nums[k]};
                        Arrays.sort(ans);
                        if(searchMe(res, ans[0], ans[1]))
                            continue;
                        res[p] = ans;
                        p++;
                    }
                }
            }
        }
        printList(res,p-1);
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums){
        Set<List<Integer>> set = new HashSet<>();
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            hash.put(0 - nums[i], i);
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(hash.containsKey(nums[i] + nums[j]) && (i != hash.get(nums[i] + nums[j]) && j != hash.get(nums[i] + nums[j]))){
                    List<Integer> list = new ArrayList<>();
                    int idx = hash.get(nums[i] + nums[j]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[idx]);
                    Collections.sort(list);
                    //System.out.print(nums[idx] + " ");
                    set.add(list);
                }
            }
        }
        System.out.println(set);
        return new ArrayList<>(set);
    }

    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        zeroSum(nums);                      //O(n^4)
        threeSum(nums);                     //Using HashMap , HashSet , O(n^2)
    }
}
