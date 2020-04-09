import java.util.*;

public class TopKFrequentElements {
    public static List<Integer> topKfrequent(int[] num, int k){
        Map<Integer, Integer> unsortedmap = new HashMap<>();
        for(int i : num)
            unsortedmap.put(i, unsortedmap.getOrDefault(i, 0) + 1);
        List<Integer> list = new ArrayList<>();
        unsortedmap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k).forEachOrdered(x -> list.add(x.getKey()));
        System.out.println(list);
        return list;
    }

    public static void main(String[] rgs){
        int[] num = {1,2,3,1,2,1};
        int k = 3;
        topKfrequent(num, k);
    }
}
