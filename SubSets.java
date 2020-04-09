import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static List<List<Integer>> getAllSubSets(int[] num){
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        for(int i = 0; i < num.length; i++){
            for(int j = i+1; j <= num.length; j++){
                List<Integer> l = new ArrayList<>();
                for(int k = i; k < j; k++){
                    l.add(num[k]);
                }
                lists.add(l);
            }
        }
        System.out.println(lists);
        return lists;
    }
    public static List<List<Integer>> lists = new ArrayList<>();
    public static void allRecursiveSubSets(int[] num, int i, String s){
        if(i >= num.length){
            if(s.equals("")){
                lists.add(new ArrayList<>());
                return;
            }
            String[] ar = s.split(" ");
            List<Integer> l = new ArrayList<>();
            for(String a : ar){
                l.add(Integer.parseInt(a));
            }
            lists.add(l);
            return;
        }else{
            allRecursiveSubSets(num, i + 1, s);
            allRecursiveSubSets(num, i + 1, s + num[i] + " ");
            return;
        }
    }

    public static List<List<Integer>> subsets(int[] S){
        List<List<Integer>> lists = new ArrayList<>();
        if(S.length == 0)
            return lists;
        dfs(S, 0, new ArrayList<Integer>(), lists);
        System.out.println(lists);
        return lists;
    }
    private static void dfs(int[] s, int index, List<Integer> path, List<List<Integer>> lists){
        lists.add(new ArrayList<>(path));
        for(int i = index; i < s.length; i++){
            path.add(s[i]);
            dfs(s, i+1, path, lists);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args){
        int[] set = {1,2,3};
        //getAllSubSets(set);                                         //Wrong Approach
        allRecursiveSubSets(set, 0, "");                        //Recursive Approach
        System.out.println(lists);
        subsets(set);
    }
}
