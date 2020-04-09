import java.util.HashMap;

public class SingleNumber {
    public static int singleNumber(int[] num){
        if(num == null || num.length == 0)
            return -1;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < num.length; i++){
            if(map.isEmpty() || !map.containsKey(num[i])){
                map.put(num[i], 1);
            }else {
                map.put(num[i], map.get(num[i]) + 1);
            }
        }
        for(int i = 0; i < num.length; i++){
            if(map.get(num[i]) == 1){
                res = num[i];
                break;
            }
        }
        System.out.println(res);
        return res;
    }

    public static int singleNumDoubleIteration(int[] num){
        int res = -1, cnt = 0; boolean flag = false;
        if(num == null || num.length == 0)
            return -1;
        for(int i = 0; i < num.length; i++){
            cnt = 1;
            for(int j = 0; j < num.length; j++){
                if(j == num.length - 1 && cnt == 1){
                    res = num[i];
                    flag = true;
                    break;
                }else if(num[i] == num[j] && i != j){
                    cnt++;
                }
            }
            if(flag)
                break;
        }
        System.out.println(res);
        return res;
    }

    public static int singleNumValueInArray(int[] num){
        for(int i = 0; i < num.length; i++){
            if(i == 0)
                num[0] = 0 ^ num[i];
            else
                num[0] = num[0]^num[i];
        }
        System.out.println(num[0]);
        return num[0];
    }

    public static int XORSolution(int[] num){
        int res = 0;
        for(int i : num){
            res = res ^ i;
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        int[] num = {2,8,2,8,6};
        singleNumber(num);
        singleNumDoubleIteration(num);
        XORSolution(num);
        singleNumValueInArray(num);
    }
}
