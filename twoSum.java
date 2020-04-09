import java.util.HashMap;

public class twoSum {
    public static int[] TwoSumBruteForce(int[] nums, int target){
        int[] res = new int[2];
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        System.out.println(res[0] + " " + res[1]);
        return res;
    }

    public static int[] TwoSumNormal(int[] nums, int target){
        int[] res = new int[2];
        int n = nums.length;
        int max = nums[0];
        for(int i = 0; i < n; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        int[] temp = new int[max + 1];
        int k = 0;
        for(int i = 0; i <= max; i++){
            if(k < n && nums[k] == i){
                temp[i] = k;
                k++;
            }else {
                temp[i] = -1;
            }
        }
        for(int i = 0; i < n; i++){
            int idx = target - nums[i];
            if(temp[idx] != -1){
                res[0] = i;
                res[1] = temp[idx];
                break;
            }
        }
        System.out.println(res[0] + " " + res[1]);
        return res;
    }

    public static int[] TwoSumNLogN(int[] nums, int target){
        int[] res = new int[2];
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int searchMe = target - nums[i];
            int start = i+1, end = n-1, idx = i;
            while(start <= end){
                int mid = (start + end)/2;
                if(nums[mid] == searchMe){
                    idx = mid;
                    break;
                }else if(nums[mid] > searchMe){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            if(idx != i){
                res[0] = i;
                res[1] = idx;
                break;
            }
        }
        System.out.println(res[0] + " " + res[1]);
        return res;
    }

    public static int[] TwoSumUsingHashMap(int[] nums, int target){
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(map.containsKey(target-nums[i])){
                res[1] = i;
                res[0] = map.get(target-nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        System.out.println(res[0] + " " + res[1]);
        return res;
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        TwoSumBruteForce(nums, 9); //O(n^2)
        TwoSumNormal(nums, 17);    //O(K) where K is maximum value in given array
        TwoSumNLogN(nums, 17);     //O(n*log(n)) if given array is sorted
        TwoSumUsingHashMap(nums, 22);//O(n) Using HashMap Key-Value pairs
    }
}
