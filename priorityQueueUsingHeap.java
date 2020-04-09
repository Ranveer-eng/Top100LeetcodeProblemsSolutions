
public class priorityQueueUsingHeap<t extends Comparable<t>> {

    t[] arr;
    int n;

    public priorityQueueUsingHeap() {
        arr = (t[]) new Comparable[2];
        n = 0;
    }

    public void addItem(t item) {
        if(n == arr.length - 1)
            resize(2*n + 1);
        arr[++n] = item;
        swim(n);
    }
    public t pollMax() {
        if(isEmpty())
            return null;
        t item = arr[1];
        exch(1, n--);
        arr[n+1] = null;
        sink(1);

        if(n == (arr.length - 1)/4)
            resize((arr.length - 1)/2 + 1);

        return item;
    }

    private boolean isEmpty() {
        return n == 0;
    }

    private void resize(int capacity) {
        t[] copy = (t[]) new Comparable[capacity];
        for(int i = 1; i <= n; i++)
            copy[i] = arr[i];
        arr = copy;
    }

    private void swim(int k) {
        while(k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while(2*k < n) {
            int val = 2*k;
            if(val < n && less(val, val + 1))
                val = val + 1;
            if(less(val, k))
                break;
            k = val;
        }
    }

    private boolean less(int i, int j) {
        if(arr[i].compareTo(arr[j]) < 0)
            return true;
        return false;
    }

    private void exch(int i, int j) {
        t temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private String tostring() {
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= n; i++) {
            sb.append(arr[i].toString() + " ");
        }
        return sb.toString();
    }

}
/*
class priorityQueue<t extends Comparable<t>>{
    t[] arr;
    int n;

    public priorityQueue() {
        arr = (t[]) new Comparable[2];
        n = 0;
    }

    public void addItem(t item) {
        if(n == arr.length - 1)
            resize(2*n + 1);
        arr[++n] = item;
        swim(n);
    }
    public t pollMax() {
        if(isEmpty())
            return null;
        t item = arr[1];
        exch(1, n--);
        arr[n+1] = null;
        sink(1);

        if(n == (arr.length - 1)/4)
            resize((arr.length - 1)/2 + 1);

        return item;
    }

    private boolean isEmpty() {
        return n == 0;
    }

    private void resize(int capacity) {
        t[] copy = (t[]) new Comparable[capacity];
        for(int i = 1; i <= n; i++)
            copy[i] = arr[i];
        arr = copy;
    }

    private void swim(int k) {
        while(k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while(2*k < n) {
            int val = 2*k;
            if(val < n && less(val, val + 1))
                val = val + 1;
            if(less(val, k))
                break;
            k = val;
        }
    }

    private boolean less(int i, int j) {
        if(arr[i].compareTo(arr[j]) < 0)
            return true;
        return false;
    }

    private void exch(int i, int j) {
        t temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private String tostring() {
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= n; i++) {
            sb.append(arr[i].toString() + " ");
        }
        return sb.toString();
    }
}
*/















