public class MaximumSubArrayProblem {
    public static int maxSubArr(int[] num){
        int res = 0;
        int n = num.length;
        if(n <=0 || (n == 1 && num[0] <= 0))
            return 0;
        for(int i = 0; i < n; i++){
            int ans = num[i];
            for(int j = i+1; j < n; j++){
                if(res < ans)
                    res = ans;
                ans += num[j];
            }
        }
        System.out.println(res);
        return res;
    }

    public static int maxSubArraySum(int[] num, int i, int n){
        if(n <= 0)
            return 0;
        int res = num[i], ans = num[i];
        for(int p = i+1; p < n; p++){
            res += num[p];
            ans += num[p];
        }
        int j = n-1;
        while (i != j){
            if(num[i] < num[j]){
                ans = ans - num[i];
                i++;
                if(ans > res)
                    res = ans;
            }else if(num[i] > num[j]){
                ans = ans - num[j];
                j--;
                if(ans > res)
                    res = ans;
            }else {
                ans = Math.max(maxSubArraySum(num, i+1, j+1), maxSubArraySum(num, i, j));
                if(ans > res)
                    res = ans;
                break;
            }
        }
        return res;
    }

    public static int maxSubArSum(int[] num){
        int size = num.length;
        int start = 0, end = 0;
        int max_so_far = 0, max_ending_here = 0;
        for(int i = 0; i < size; i++){
            if(num[i] > max_ending_here + num[i]){
                start = i;
                max_ending_here = num[i];
            }else {
                max_ending_here = max_ending_here + num[i];
            }
            if(max_so_far < max_ending_here){
                max_so_far = max_ending_here;
                end = i;
            }
        }
        //Maximum sum found between start and end index;
        System.out.println(max_so_far);
        return max_so_far;
    }

    public static int DynamicProMaxSubArrSum(int[] num){
        int[] solution = new int[num.length + 1];
        solution[0] = 0;

        for(int j = 1; j < solution.length; j++){
            solution[j] = Math.max(solution[j-1] + num[j-1], num[j-1]);
        }
        int res = solution[0];
        for(int j = 1; j < solution.length; j++){
            if(res < solution[j]){
                res = solution[j];
            }
        }
        System.out.println(res);
        return res;
    }

    public static int divideANDconquerMaxArrSum(int[] num, int start, int end){
        if(start > end || start > num.length || end < 0)
            return 0;
        else if(start == end){
            return num[start];
        }else {
            int mid = (start+end)/2;
            int left_shift_sum = Integer.MIN_VALUE, right_shift_sum = Integer.MIN_VALUE, mid_Left = 0, mid_Right = 0;
            for(int i = mid; i >= start; i--){
                mid_Left += num[i];
                if(mid_Left > left_shift_sum)
                    left_shift_sum = mid_Left;
            }
            for(int j = mid+1; j <= end; j++){
                mid_Right += num[j];
                if(mid_Right > right_shift_sum)
                    right_shift_sum = mid_Right;
            }
            int leftSum = divideANDconquerMaxArrSum(num, start, mid);
            int rightSum = divideANDconquerMaxArrSum(num, mid+1, end);
            return Math.max(Math.max(leftSum, rightSum), left_shift_sum+right_shift_sum);
        }
    }

    public static void main(String[] args){
        int[] num = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArr(num);                                                             //Brute Force Approach
        int test = maxSubArraySum(num, 0, num.length);
        System.out.println(test);                                                   //Recursive Slide Method
        maxSubArSum(num);                                                           //Kadane's Algorithm
        DynamicProMaxSubArrSum(num);                                                //Dynamic Programming
        int[] nums = {10,2,7};
        test = divideANDconquerMaxArrSum(nums, 0, nums.length - 1);        //Divide And Conquer Method
        System.out.println(test);
    }
}
