
public class PartitionEqualSubSetSum {
    public static boolean partitionEqual(int[] array){
        if (array.length <= 1)
            return false;
        int total = 0;
        boolean ans;
        for(int i : array)
            total += i;
        if(total%2 == 1) {
            ans = false;
        }else {
            ans = knapsack(array, 0, total / 2);
        }
        System.out.println(ans);
        return ans;
    }
    private static boolean knapsack(int[] array, int i, int total){
        if(total == 0)
            return true;
        if(total < 0 || i > array.length - 1)
            return false;
        else
            return knapsack(array, i + 1, total - array[i]) || knapsack(array, i + 1, total);
    }

    public static void main(String[] args){
        int[] array = {21,6,15,12};
        partitionEqual(array);
    }
}
