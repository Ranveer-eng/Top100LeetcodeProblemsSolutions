import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> getCombination(int[] num, int target){
        List<List<Integer>> lists = new ArrayList<>();
        //List<Integer> list = new ArrayList<>();
        recursiveCall(num, target, 0, lists, "");
        System.out.println(lists);
        return lists;
    }
    private static void recursiveCall(int[] num, int target, int index, List<List<Integer>> lists, String s){
        if(index > num.length - 1){
            return;
        }else if(target < num[index]){
            return;
        }
        if(target == num[index]){
            s += num[index];
            String[] ar = s.split(" ");
            List<Integer> l = new ArrayList<>();
            for(String a : ar){
                l.add(Integer.parseInt(a));
            }
            lists.add(l);
            return;
        }else{
            recursiveCall(num, target - num[index], index, lists, s + num[index] + " ");
            recursiveCall(num, target, index + 1, lists, s);
            return;
        }
    }

    public static List<List<Integer>> combinationListApproach(int[] num, int target){
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        help(num, 0, target, 0, temp, lists);
        System.out.println(lists);
        return lists;
    }
    private static void help(int[] num, int start, int target, int sum, List<Integer> temp, List<List<Integer>> lists){
        if(sum > target)
            return;
        if(sum == target){
            lists.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < num.length; i++){
            temp.add(num[i]);
            help(num, i, target, sum + num[i], temp, lists);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args){
        int[] num = {2,3,5};
        int target = 8;
        getCombination(num, target);
        combinationListApproach(num, target);
    }
}
