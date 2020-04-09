import java.util.Arrays;
import java.util.HashMap;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] num){
        if(num.length <= 0)
            return 1;
        else if(num.length == 1){
            if(num[0] != 1)
                return 1;
            else
                return 2;
        }else{
            Arrays.sort(num);
            if(BinarySearch(num, 1) != -1){
                int idx = BinarySearch(num, 1);
                for(int i = 0; i < num.length-idx; i++){
                    if(num[idx + i] != i+1){
                        System.out.println(i+1);
                        return i+1;
                    }
                }
                System.out.println(num[num.length-1] + 1);
                return num[num.length - 1] + 1;
            }else {
                System.out.println(1);
                return 1;
            }
        }
    }
    private static int BinarySearch(int[] num, int value){
        int start = 0, end = num.length - 1;
        while (start <= end){
            int mid = (start + end)/2;
            if(num[mid] == value)
                return mid;
            else if(num[mid] > value)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static int firstPositiveMissing(int[] num){
        int n = num.length;
        if(n <= 0)
            return 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = 0, max = 0, res = 1;
        for(int i = 0; i < n; i++){
            map.put(num[i], i);
            if(num[i] == 1)
                min = 1;
            if(num[i] > max)
                max = num[i];
        }
        if(min != 1){
            System.out.println(1);
            return 1;
        }
        int i = 0;
        for( i = 1; i <= max; i++){
            if(!map.containsKey(i)){
                System.out.println(i);
                return i;
            }
        }
        System.out.println(i);
        return i;
    }

    public static int firstMissingPositiveOptimal(int[] num){
        int n = num.length;
        if(n==0)
            return 1;
        int p, i;
        for(i = 0; i < n; i++){
            if(num[i] <= 0 || num[i] >= n)
                continue;
            p = num[i] - 1;
            if(num[p] != num[i]){
                int temp = num[p];
                num[p] = num[i];
                num[i] = temp;
                i--;
            }
        }
        for(i = 0; i < n; i++){
            if(num[i] != i+1)
                return (i+1);
        }
        return n+1;
    }

    public static void main(String[] args){
        int[] num = {1,2,0};
        firstMissingPositive(num);                                             //O(n*log(n))
        firstPositiveMissing(num);                                             //Time --> O(n), Space --> (n)
        int test = firstMissingPositiveOptimal(num);                           //Time --> (n)
        System.out.println(test);
    }
}
