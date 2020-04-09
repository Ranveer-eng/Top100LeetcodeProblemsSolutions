import java.util.Stack;

public class DailyTemperature {
    public static int[] dailyTemp(int[] num){
        int[] res = new int[num.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = num.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && num[i] >= num[stack.peek()]){
                stack.pop();
            }
            if (stack.isEmpty())
                res[i] = 0;
            else
                res[i] = stack.peek() - i;
            stack.push(i);
        }
        printArray(res);
        return res;
    }
    private static void printArray(int[] num){
        for(int a : num){
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static int[] dailyT(int[] num){
        int[] res = new int[num.length];
        for(int i = 0; i < num.length; i++){
            int j = i+1;
            for (; j< num.length && num[j] <= num[i]; j++);
            res[i] = j == num.length ? 0 : j - i;
        }
        printArray(res);
        return res;
    }

    public static void main(String[] args){
        int[] ar = {73,74,75,71,69,72,76,73};
        dailyT(ar);
        dailyTemp(ar);
    }
}
