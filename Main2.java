import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    /*
    public static int maxEggs(List<Integer> list, int k){
        if(list.size() <= 0 || k < 0)
            return 0;
        int res = 0;
        for(int i = 0; i < k; i++){
            int val = Collections.max(list);
            res += val;
            list.remove((Object) val);
            list.add(val/2);
        }
        return res;
    }
    */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        //List<Integer> list = new ArrayList<>();
        int[] ar = new int[n];
        maxHeap heap = new maxHeap(n);
        int ans = 0;
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            //list.add(val);
            ar[i] = val;
            /*
            heap.insertInHeap(val);
            int max = heap.MaxValueInHeap();
            ans += max;
            heap.insertInHeap(max/2);
            */
        }
        //System.out.println(maxEggs(list, k));
        /*
        maxHeap heap = new maxHeap(2);
        int k = 3;
        int[] ar = {6,5};
        int ans = 0;

         */
        heap.createMaxHeap(ar);
        for(int i = 0; i < k; i++){
            int max = heap.MaxValueInHeap();
            ans += max;
            heap.insertInHeap(max/2);
        }
        System.out.println(ans);
    }
}


class maxHeap{
    public int capacity;
    public int[] maxHeap;
    public int size;
    public maxHeap(int capacity){
        this.capacity = capacity;
        maxHeap = new int[capacity + 1];
        size = 0;
    }

    public void createMaxHeap(int[] ar){
        if(ar.length > 0){
            for(int i = 0; i < ar.length; i++){
                insertInHeap(ar[i]);
            }
        }
    }
    public void insertInHeap(int data){
        if(size == capacity){
            return;
        }
        size++;
        maxHeap[size] = data;
        Heapification(size);
    }
    public void Heapification(int pos){
        int parentPosition = pos/2;
        int currentPos = pos;
        while (currentPos > 0 && maxHeap[parentPosition] < maxHeap[currentPos]){
            swap(currentPos, parentPosition);
            currentPos = parentPosition;
            parentPosition = parentPosition/2;
        }
    }
    public void swap(int x, int y){
        int temp = maxHeap[x];
        maxHeap[x] = maxHeap[y];
        maxHeap[y] = temp;
    }
    public int MaxValueInHeap(){
        int max = maxHeap[0];
        maxHeap[0] = maxHeap[size];
        maxHeap[size] = 0;
        ReverseHeapification(0);
        size--;
        return max;
    }
    public void ReverseHeapification(int pos){
        int maximumIndex = pos;
        int left = 2*pos;
        int right = 2*pos + 1;
        if(left < heapSize() && maxHeap[maximumIndex] < maxHeap[left]){
            maximumIndex = left;
        }
        if (right < heapSize() && maxHeap[maximumIndex] < maxHeap[right]){
            maximumIndex = right;
        }
        if(maximumIndex != pos){
            swap(pos, maximumIndex);
            ReverseHeapification(maximumIndex);
        }
    }
    public int heapSize(){
        return size;
    }
}