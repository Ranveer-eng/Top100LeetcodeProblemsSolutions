import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static int findKthUsingSort(int[] ar, int k){
        if(k > ar.length)
            return -1;
        Arrays.sort(ar);
        int res = ar[ar.length - k];
        System.out.println(res);
        return res;
    }

    public static int findKthUsingHeap(int[] ar, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i : ar){
            pq.offer(i);
            if(pq.size() > k)
                pq.poll();
        }
        int res = pq.peek();
        System.out.println(res);
        return res;
    }

    public static int findKthUsingQuickSort(int[] ar, int k){
        if(k < 1 || k > ar.length || ar == null)
            return 0;
        int res = getKthQuick(ar.length - k + 1, ar, 0, ar.length - 1);
        System.out.println(res);
        return res;
    }
    private static int getKthQuick(int k, int[] ar, int start, int end){
        int pivot = ar[end];
        int left = start, right = end;
        while (true){
            while (ar[left] < pivot && left < right){
                left++;
            }
            while (ar[right] >= pivot && right > left)
                right--;
            if(left == right)
                break;
            int temp = ar[left];
            ar[left] = ar[right];
            ar[right] = temp;
        }
        int temp = ar[left];
        ar[left] = ar[end];
        ar[end] = temp;

        if(k == left + 1)
            return pivot;
        else if(k < left + 1)
            return getKthQuick(k, ar, start, left - 1);
        else
            return getKthQuick(k, ar, left+1, end);
    }

    public static void main(String[] args){
        int[] ar = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        findKthUsingSort(ar, k);
        findKthUsingHeap(ar, k);
        findKthUsingQuickSort(ar, k);
    }
}
//
//class kthNode{
//    int data;
//    kthNode left;
//    kthNode right;
//    public kthNode(){
//        left = null;
//        right = null;
//    }
//    public kthNode(int k){
//        this.data = k;
//        this.left = null;
//        this.right = null;
//    }
//}