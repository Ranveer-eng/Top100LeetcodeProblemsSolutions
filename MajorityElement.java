import java.util.*;

public class MajorityElement {
    public static int majorEle(int[] num){
        int cnt = 1, resIndex = 0, count = 1;
        for(int i = 0; i < num.length; i++){
            for(int j = i + 1; j < num.length; j++){
                if(num[i] == num[j]){
                    cnt++;
                    resIndex = i;
                }
                if(count < cnt)
                    count = cnt;
            }
            if(count >= num.length/2){
                resIndex = i;
                break;
            }
        }
        System.out.println(num[resIndex]);
        return num[resIndex];
    }

    public static int majorItemUsingHashMap(int[] num){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < num.length; i++){
            if(map.containsKey(num[i]))
                map.put(num[i], map.get(num[i]) + 1);
            else
                map.put(num[i], 1);
        }
        int res = Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry :: getValue)).getKey();
        System.out.println(res);
        return res;
    }

    public static int majorityElementUsingSorting(int[] num){
        if(num.length == 1){
            return num[0];
        }
        Arrays.sort(num);
        System.out.println(num[num.length/2]);
        return num[num.length/2];
    }

    public static int majorityElementInArray(int[] num){
        int res = 0, cnt = 0;
        for(int i = 0; i < num.length; i++){
            if(cnt == 0){
                res = num[i];
                cnt = 1;
            }else if(num[i] == res)
                cnt++;
            else
                cnt--;
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        int[] num = {2,2,1,1,2,2};
        majorEle(num);
        majorItemUsingHashMap(num);
        majorityElementUsingSorting(num);
        majorityElementInArray(num);
    }
}
