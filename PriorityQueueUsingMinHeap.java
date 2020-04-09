import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PriorityQueueUsingMinHeap {

    public static void prefixing(int[] ar, int[][] mat){
        for(int i = 0; i < 32; i++){
            for(int j = 0; j < ar.length; j++){
                if(j > 0)
                    mat[i][j] = mat[i][j-1];
                if((ar[j] & (1 << i)) >= 1)
                    mat[i][j]++;
            }
        }
    }

    public static void preprocess(int[] ar,int[] original ,int[][] matrix){
        for(int i = 0; i < 32; i++){
            for(int index : ar){

            }
        }
    }

    public static int XOR(int[][] mat, int first, int second, int third){
        int res = 0, countOnes = 0;
        int[] ar = {first, second, third};
        for(int j : ar) {
            for (int i = 0; i < 32; i++) {
                countOnes = mat[i][j] - (j > 0 ? mat[i][j - 1] : 0);
                if (countOnes % 2 == 1)
                    res += (1 << i);
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException{
        //Scanner sc = new Scanner(System.in);
//        int[] ar = {5,4,3,2,1};
//        minHeap pq = new minHeap(ar, 0, 3);
//        int firstMin = pq.getMin();
//        int second = pq.getMin();
//        int third = pq.getMin();
//        int a = (firstMin^second)^third;
//        System.out.println(a);
        BufferedReader Reader1 = new BufferedReader(new InputStreamReader(System.in));
        /*
        int n = Integer.parseInt(Reader1.readLine());
        int[] ar = new int[n];
        String s = Reader1.readLine();
        String[] arstr = s.split(" ");

         */
        int[] ar = {5,4,3,2,1};
        int[][] mat = new int[32][5];
        prefixing(ar, mat);
        /*
        int q = Integer.parseInt(Reader1.readLine());//= sc.nextInt();
        for(int i = 0; i < q; i++){
            int end = Integer.parseInt(Reader1.readLine());//= sc.nextInt();
            if(n <= 2)
                System.out.println(-1);
            if(end < 3)
                System.out.println(-1);
            else {

                minHeap pq = new minHeap(ar, 0, end - 1);

                int a = pq.getMin();
                int b = pq.getMin();
                int c = pq.getMin();
                //int ans = (a^b)^c;
                a = 2; b = 1; c = 0;
                System.out.println(a + " " + b + " " + c);
                int ans = XOR(mat, a, b, c);
                System.out.println(ans);
            }
        }
        */
        int ans = XOR(mat, 2, 1, 0);
        System.out.println(ans);
    }
}

class minHeap{
    private doubleNode[] elements;
    int size;

    public minHeap(int capacity) {
        this.elements = new doubleNode[capacity + 1];
        this.size = 0;
    }

    public minHeap() {
        this(1);
    }
    public minHeap(int[] keys, int l, int r) {
        this.size = r - l + 1;
        this.elements = new doubleNode[size + 1];
        int m = 0;
        for(int i = l; i <= r; i++) {
            this.elements[m+1] = new doubleNode(keys[i], i);
            m++;
        }
        for(int k = size/2; k >= 1; k--)
            sink(k);
        assert isMaxHeap();
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    public int min() {
        return this.elements[1].value;
    }
    public void resize(int capacity) {
        assert capacity > size;
        doubleNode[] temp = new doubleNode[capacity];
        for(int i = 1; i <= this.size; i++)
            temp[i] = this.elements[i];
        this.elements = temp;
    }
    /*
    public void add(int x) {
        if(size >= elements.length - 1)
            resize(2*elements.length);
        elements[++size] = x;
        bubbleUp(size);
        assert isMaxHeap();
    }

     */
    public int getMin() {
        int max = elements[1].index;
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
        return this.elements[i].value >= this.elements[j].value;
    }
    private void swap(int i, int j) {
        doubleNode temp = this.elements[i];
        this.elements[i] = this.elements[j];
        this.elements[j] = temp;
    }
    public void print() {
        for(int i = 1; i <= size; i++)
            System.out.print(elements[i].value + " ");
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

class doubleNode{
    int index;
    int value;
    public doubleNode(int value, int key){
        this.index = key;
        this.value = value;
    }
}












