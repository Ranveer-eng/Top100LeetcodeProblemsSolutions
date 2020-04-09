import java.util.Deque;
import java.util.LinkedList;

public class MaximumSlidingWindow {
    public static int[] maxElementWindow(int[] num, int k){
        if(num.length < k)
            return new int[0];
        int[] res = new int[num.length - k + 1];
        int i = 0, j = k - 1;
        while (j < num.length){
            int ans = getMax(num, i, j);
            res[i] = ans;
            System.out.print(ans + " ");
            i++;
            j++;
        }
        System.out.println();
        return res;
    }
    private static int getMax(int[] num, int l, int r){
        int max = num[l];
        for(int i = l; i <= r; i++){
            if(max < num[i])
                max = num[i];
        }
        return max;
    }

    public static int[] maxWindow(int[] num, int k){
        if(k <= 0 || num == null || num.length == 0){
            return null;
        }
        int[] res = new int[num.length - k + 1];
        int i = 0, j = k, l = 0;
        res[0] = num[0];
        for(int m = 0; m < k; m++){
            if(num[m] > res[0]) {
                l = m;
                res[0] = num[m];
            }
        }
        System.out.print(res[0] + " ");
        while (j < num.length){
            if(res[i] > num[j]){
                res[i+1] = res[i];
                System.out.print(res[i+1] + " ");
                i++;
                j++;
            }else{
                res[i+1] = num[j];
                System.out.print(res[i+1] + " ");
                i++;
                j++;
            }
        }
        System.out.println();
        return res;
    }

    public static int[] maxWinPeoblem(int[] num, int k){
        if(num == null || num.length == 0 || k <= 0)
            return null;
        int[] res = new int[num.length - k + 1];
        Bst bst = new Bst();
        Nodebst root = null;
        int j = 0;
        for(j = 0; j < k && j < num.length; j++){
            root = bst.insert(root, num[j]);
        }

        for(int i = 0; j < num.length+1; i++, j++){
            res[i] = bst.getMaxValue(root);
            System.out.print(res[i] + " ");
            if(j < num.length)
                root = bst.insert(root, num[j]);
            root = bst.deleteNode(root, num[i]);

        }
        System.out.println();
        return res;
    }

    public static int[] maxWindowSlide(int[] num, int k){
        if(num == null || num.length == 0 || k <= 0)
            return null;
        int[] res = new int[num.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < num.length; i++){
            while (!deque.isEmpty() && num[i] >= num[deque.getLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
            if(i - deque.getFirst() + 1 > k){
                deque.removeFirst();
            }
            if(i + 1 >= k){
                res[i+1-k] = num[deque.getFirst()];
                System.out.print(res[i+1-k] + " ");
            }
        }
        System.out.println();
        return res;
    }

    public static void main(String[] args){
        int[] num = {8,1,7, 5,3, 4,6,3,4,6,2,2,1};
        int k = 5;
        maxElementWindow(num, k);
        //maxWindow(num, k);
        maxWinPeoblem(num, k);
        maxWindowSlide(num, k);
    }
}


class Bst {

    //isLeaf()

    public int isBST(Nodebst root) {
        if (ifBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return 1;
        } else {
            return 0;
        }
    }

    private static boolean ifBST(Nodebst root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        } else if (root.data < minValue || root.data > maxValue) {
            return false;
        }
        return ifBST(root.left, minValue, root.data) && ifBST(root.right, root.data, maxValue);
    }


    public boolean isLeaf(Nodebst root) {
        if (root.right == null && root.left == null || root == null) {
            return true;
        }
        return false;
    }

    public int getMax(int x, int y) {
        return x > y ? x : y;
    }

    public int getHeight(Nodebst root) {
        if (root == null || isLeaf(root)) {
            return 0;
        }
        return getMax(getHeight(root.left), getHeight(root.right) + 1);
    }

    //Node root = new Node();
    public Nodebst createNewNode(int val) {
        Nodebst root = new Nodebst();
        root.data = val;
        root.left = null;
        root.right = null;
        return root;
    }

    public Nodebst insert(Nodebst root, int val) {
        if (root == null) {
            return createNewNode(val);
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else if (val >= root.data) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Get minimum element in binary search tree
    public static Nodebst minimumElement(Nodebst root) {
        if (root.left == null)
            return root;
        else {
            return minimumElement(root.left);
        }
    }

    public Nodebst deleteNode(Nodebst root, int value) {
        if (root == null)
            return null;
        if (root.data > value) {
            root.left = deleteNode(root.left, value);
        } else if (root.data < value) {
            root.right = deleteNode(root.right, value);

        } else {
            // if nodeToBeDeleted have both children
            if (root.left != null && root.right != null) {
                Nodebst temp = root;
                // Finding minimum element from right
                Nodebst minNodeForRight = minimumElement(temp.right);
                // Replacing current node with minimum node from right subtree
                root.data = minNodeForRight.data;
                // Deleting minimum node from right now
                root.right = deleteNode(root.right, minNodeForRight.data);

            }
            // if nodeToBeDeleted has only left child
            else if (root.left != null) {
                root = root.left;
            }
            // if nodeToBeDeleted has only right child
            else if (root.right != null) {
                root = root.right;
            }
            // if nodeToBeDeleted do not have child (Leaf node)
            else
                root = null;
        }
        return root;
    }

    public int getMaxValue(Nodebst root) {
        if(root == null) {
            System.out.println("Tree is Empty.");
            return -1;
        }

        while(root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    //Getting minimum value in tree
    public int getMinValue(Nodebst root) {
        if(root == null) {
            System.out.println("Tree is Empty.");
            return -1;
        }
        while(root.left != null) {
            root = root.left;
        }
        return root.data;
    }
}


class Nodebst{
    int data;
    Nodebst left;
    Nodebst right;
}










//
//class priorityQMax{
//    private int[] elements;
//    int size;
//
//    public priorityQMax(int capacity) {
//        this.elements = new int[capacity + 1];
//        this.size = 0;
//    }
//
//    public priorityQMax() {
//        this(1);
//    }
//    public priorityQMax(int[] keys) {
//        size = keys.length;
//        this.elements = new int[keys.length + 1];
//        for(int i = 0; i < size; i++) {
//            this.elements[i+1] = keys[i];
//        }
//        for(int k = size/2; k >= 1; k--)
//            sink(k);
//        assert isMaxHeap();
//    }
//    public boolean isEmpty() {
//        return this.size == 0;
//    }
//    public int max() {
//        return this.elements[1];
//    }
//    public void resize(int capacity) {
//        assert capacity > size;
//        int[] temp = new int[capacity];
//        for(int i = 1; i <= this.size; i++)
//            temp[i] = this.elements[i];
//        this.elements = temp;
//    }
//    public void add(int x) {
//        if(size >= elements.length - 1)
//            resize(2*elements.length);
//        elements[++size] = x;
//        bubbleUp(size);
//        assert isMaxHeap();
//    }
//    public int getMax() {
//        int max = elements[1];
//        swap(1, size--);
//        sink(1);
//        if(size > 0 && size == (elements.length - 1)/4)
//            resize(elements.length/2);
//        assert isMaxHeap();
//        return max;
//    }
//    private void bubbleUp(int k) {
//        while(k > 1 && less(k/2, k)) {
//            swap(k , k / 2);
//            k = k / 2;
//        }
//    }
//    private void sink(int k) {
//        while(2*k <= size) {
//            int j = 2*k;
//            if(j < size && less(j, j+1))
//                j++;
//            if(!less(k, j))
//                break;
//            swap(k, j);
//            k = j;
//        }
//    }
//    private boolean less(int i, int j) {
//        return this.elements[i] < this.elements[j];
//    }
//    private void swap(int i, int j) {
//        int temp = this.elements[i];
//        this.elements[i] = this.elements[j];
//        this.elements[j] = temp;
//    }
//    public void print() {
//        for(int i = 1; i <= size; i++)
//            System.out.print(elements[i] + " ");
//        System.out.println();
//    }
//    private boolean isMaxHeap() {
//        return isMaxHeap(1);
//    }
//    private boolean isMaxHeap(int k) {
//        if(k > size)
//            return true;
//        int left = 2*k, right = 2*k + 1;
//        if(left <= size && less(k, left))
//            return false;
//        if(right <= size && less(k, right))
//            return false;
//        return isMaxHeap(left) && isMaxHeap(right);
//    }
//}
