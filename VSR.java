import java.io.*;
import java.util.*;

public class VSR {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//Integer.parseInt(st.nextToken());
        for(int i = 0; i < t; i++){
            int n = sc.nextInt() ;//Integer.parseInt(st.nextToken());
            int k = sc.nextInt() ;//Integer.parseInt(st.nextToken());
            sc.nextLine();
            String[] strA = sc.nextLine().split(" ") ;//br.readLine().split(" ");
            int[] arOfW = new int[k];
            int sum = 0;
            for(int j = 0; j < k; j++){
                arOfW[j] = Integer.parseInt(strA[j]);
                sum += arOfW[j];
            }
            String[] strAr = sc.nextLine().split(" ") ;//br.readLine().split(" ");
            int[] arOO = new int[n];
            for(int j = 0; j < n; j++){
                arOO[j] = Integer.parseInt(strAr[j]);
            }
            maxHeapPriority pq = new maxHeapPriority(arOfW);
            int[] ar = new int[k];
            int maxSum = 0;
            for(int j = 0; j < k; j++){
                ar[j] = pq.getMax();
                maxSum += ar[j];
                pq.add((int) Math.ceil(ar[j]/2));
            }
            System.out.println(sum - maxSum);
        }
    }
}

class maxHeapPriority{
    private int[] elements;
    int size;

    public maxHeapPriority(int capacity) {
        this.elements = new int[capacity + 1];
        this.size = 0;
    }

    public maxHeapPriority() {
        this(1);
    }
    public maxHeapPriority(int[] keys) {
        size = keys.length;
        this.elements = new int[keys.length + 1];
        for(int i = 0; i < size; i++) {
            this.elements[i+1] = keys[i];
        }
        for(int k = size/2; k >= 1; k--)
            sink(k);
        assert isMaxHeap();
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    public int max() {
        return this.elements[1];
    }
    public void resize(int capacity) {
        assert capacity > size;
        int[] temp = new int[capacity];
        for(int i = 1; i <= this.size; i++)
            temp[i] = this.elements[i];
        this.elements = temp;
    }
    public void add(int x) {
        if(size >= elements.length - 1)
            resize(2*elements.length);
        elements[++size] = x;
        bubbleUp(size);
        assert isMaxHeap();
    }
    public int getMax() {
        int max = elements[1];
        swap(1, size--);
        sink(1);
        if(size > 0 && size == (elements.length - 1)/4)
            resize(elements.length/2);
        assert isMaxHeap();
        return max;
    }
    private void bubbleUp(int k) {
        while(k > 1 && less(k/2, k)) {
            swap(k , k / 2);
            k = k / 2;
        }
    }
    private void sink(int k) {
        while(2*k <= size) {
            int j = 2*k;
            if(j < size && less(j, j+1))
                j++;
            if(!less(k, j))
                break;
            swap(k, j);
            k = j;
        }
    }
    private boolean less(int i, int j) {
        return this.elements[i] < this.elements[j];
    }
    private void swap(int i, int j) {
        int temp = this.elements[i];
        this.elements[i] = this.elements[j];
        this.elements[j] = temp;
    }
    public void print() {
        for(int i = 1; i <= size; i++)
            System.out.print(elements[i] + " ");
        System.out.println();
    }
    private boolean isMaxHeap() {
        return isMaxHeap(1);
    }
    private boolean isMaxHeap(int k) {
        if(k > size)
            return true;
        int left = 2*k, right = 2*k + 1;
        if(left <= size && less(k, left))
            return false;
        if(right <= size && less(k, right))
            return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }
}
















