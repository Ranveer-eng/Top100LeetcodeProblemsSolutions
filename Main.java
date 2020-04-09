import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void GuviAndSubArray(int[] ar, int k){
        int n = ar.length;
        List<Integer> get_Left ;
        get_Left = GetLeft(ar, n);
        List<Integer> minimumSums = new ArrayList<>();
        List<Integer> maximumSums = new ArrayList<>();
        List<Integer> realArray = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            minimumSums.add(i,Integer.MAX_VALUE);
            maximumSums.add(i,Integer.MIN_VALUE);
            realArray.add(i,0);
        }
        minimumSums.add(0, 0);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                realArray.add(j, get_Left.get(i) - minimumSums.get(j));
            }
            updatingRightSide(maximumSums, realArray);
            updatingLeftSide(minimumSums, get_Left.get(i));
        }
        for(int a : maximumSums){
            System.out.print(a + " ");
        }
        System.out.println();
    }
    private static void updatingLeftSide(List<Integer> minimumSums, int getLeftValue){
        for(int i = 0; i < minimumSums.size(); i++){
            if(getLeftValue < minimumSums.get(i)){
                minimumSums.add(i, getLeftValue);
                minimumSums.remove(minimumSums.size() - 1);
                break;
            }
        }
    }
    private static void updatingRightSide(List<Integer> maximumSums,List<Integer> real){
        for(int i = 0, j = 0; i < maximumSums.size(); i++){
            if(real.get(j) > maximumSums.get(i)){
                maximumSums.add(i, real.get(j));
                maximumSums.remove(maximumSums.size() - 1);
                j++;
            }
        }
    }

    private static List<Integer> GetLeft(int[] ar, int n){
        List<Integer> l = new ArrayList<>();
        l.add(ar[0]);
        for(int i = 1; i < n; i++){
            l.add(l.get(i-1) + ar[i]);
        }
        return l;
    }
    public static List<Integer> lst = new ArrayList<>();
    public static String s = " ";
    public static void getFirstLargestK(int[] num, int k){
        divideANDconquerMaxArrSum(num, 0, num.length - 1);
        String[] str = s.split(" ");
        for(String st : str){
            System.out.print(st + " ");
        }
        System.out.println();
        System.out.println(lst);
    }

    public static int divideANDconquerMaxArrSum(int[] num, int start, int end){
        if(start > end || start > num.length || end < 0)
            return 0;
        else if(start == end){
            if(!s.contains(" " + (num[start]) + " ")) {
                lst.add(num[start]);
                s += num[start] + "  ";
            }
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
            if(!s.contains(" "+(leftSum) + " ")){
                lst.add(leftSum);
                s += leftSum + " ";
            }
            if(!s.contains(" " + (rightSum) + " ")){
                lst.add(rightSum);
                s += rightSum + " ";
            }
            if(!s.contains(" " + (left_shift_sum + right_shift_sum) + " ")){
                lst.add(left_shift_sum+right_shift_sum);
                s += (left_shift_sum + right_shift_sum) + " ";
            }
            return Math.max(Math.max(leftSum, rightSum), left_shift_sum+right_shift_sum);
        }
    }

    public static int maxSubArraySum(int[] num, int i, int n, int k){
        if(n <= 0)
            return 0;
        int res = num[i], ans = num[i];
        for(int p = i+1; p < n; p++){
            res += num[p];
            ans += num[p];
        }
        int j = n-1;
        int OnlyLeft = num[0], OnlyRight = num[j], InMid = OnlyLeft + OnlyRight;
        //int k = 10;
        int pL = 0, pR = j;
        System.out.print(ans + " ");
        k--;
        while (k > 0){
            if(OnlyLeft == Math.min(Math.min(OnlyLeft, OnlyRight), InMid)){
                System.out.print(ans- OnlyLeft+ " ");
                pL++;
                OnlyLeft += num[pL];
                k--;
            }else if(OnlyRight == Math.min(Math.min(OnlyLeft, OnlyRight), InMid)){
                System.out.print(ans - OnlyRight + " ");
                pR--;
                OnlyRight += num[pR];
                k--;
            }else {
                System.out.print(ans - InMid + " ");
                if(num[i] == Math.min(num[i], num[j])){
                    i++;
                    InMid += num[i];
                }else {
                    j--;
                    InMid += num[j];
                }
                k--;
            }
        }
        System.out.println();
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] ar = new int[n];
            for(int j = 0; j < n; j++){
                ar[j] = sc.nextInt();
            }
            //GuviAndSubArray(ar, k);
            maxSubArraySum(ar, 0, ar.length, k);
        }
        */

        int[] ar = {10,2,7};
        //getFirstLargestK(ar, 3);
        int[] ar2 = {1,5,2,4,7,6,8,9};
        GuviAndSubArray(ar2, 15);
        maxSubArraySum(ar2, 0, ar2.length, 15);


    }
}
