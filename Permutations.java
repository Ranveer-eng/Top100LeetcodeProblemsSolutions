import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permutate(int[] num){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        getAllPer(list, "", num, 0);
        System.out.println(list);
        return list;
    }
    private static void getAllPer(List<List<Integer>> list, String s, int[] num, int l){
        if(l == num.length){
            String[] ar = s.split(" ");
            List<Integer> lst = new ArrayList<>();
            for(String a : ar)
                lst.add(Integer.parseInt(a));
            list.add(lst);
            return;
        }else if(l > num.length){
            //l.remove(l.size()-1);
            return;
        }else{
            for(int i = 0; i < num.length; i++){
                if(!s.contains(String.valueOf(num[i]))){
                    getAllPer(list, s + num[i] + " ", num, l+1);
                }
            }
            return;
        }
    }

     public static ArrayList<ArrayList<Integer>> permutations(int[] nums){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++){
            ArrayList<ArrayList<Integer>> current = new ArrayList<>();
            for(List<Integer> l : list){
                for(int j = 0; j < l.size()+1; j++){
                    l.add(j, nums[i]);
                    ArrayList<Integer> temp = new ArrayList<>(l);
                    current.add(temp);
                    l.remove(j);
                }
            }
            list = new ArrayList<>(current);
        }
        System.out.println(list);
        return list;
     }

     public static List<List<Integer>> permution(int[] num){
        List<List<Integer>> list = new ArrayList<>();
        helper(0, num, list);
         System.out.println(list);
        return list;
     }
     private static void helper(int start, int[] num, List<List<Integer>> list){
        if(start == num.length - 1){
            ArrayList<Integer> l = new ArrayList<>();
            for(int n : num){
                l.add(n);
            }
            list.add(l);
            return;
        }
        for(int i = start; i < num.length; i++){
            swap(num, i, start);
            helper(start+1, num, list);
            swap(num, i, start);
        }
     }
     private static void swap(int[] num, int i, int start){
        int temp = num[i];
        num[i] = num[start];
        num[start] = temp;
     }

    public static void main(String[] args){
        int[] num = {1,2,5};
        permutate(num);
        permutations(num);
        permution(num);
    }
}
