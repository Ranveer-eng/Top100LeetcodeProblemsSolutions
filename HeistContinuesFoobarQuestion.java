import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class HeistContinuesFoobarQuestion {

    public static void main(String[] args) throws IOException{
        huff huf = new huff();
//        HashMap<Character, Integer> map = new HashMap<>();
//        map.put('a', 2);map.put('b', 1);map.put('i', 1); map.put('m', 1);map.put('n', 1);
//        map.put('o', 2);map.put('t', 1);
//        huf.huffmanTree(new StringBuilder("101101111111110111110011111111111011110"), map);
        Scanner sc = new Scanner(System.in);
        //String s = sc.nextLine();
        //String s = "aaaabccd";
        //String decoded = "111111111111011011010";
        //Reader.init(System.in);

        int t = sc.nextInt();
        //t = Reader.nextInt();
        for(int i = 0; i < t; i++){
            HashMap<Character, Integer> map = new HashMap<>();
            int n = sc.nextInt();
            //n = Reader.nextInt();
            sc.nextLine();
            //String[][] arr = new String[n][n];
            for(int j = 0; j < n; j++){
                String cs = sc.nextLine();
                //cs = Reader.next();
                //arr[j] = cs.split(" ");
                map.put(cs.charAt(0), Integer.parseInt(cs.substring(2) + 1));
            }
            String decoded = sc.nextLine();
            //decoded = Reader.next();
            StringBuilder decode = new StringBuilder(decoded);
            huf.huffmanTree(decode, map);
            System.out.println();
        }
    }
}




/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}

class huff{
    public void encoding(tNode root, String str, Map<Character, String> huffmanmap) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            huffmanmap.put(root.c, str);

        encoding(root.left, str + "0", huffmanmap);
        encoding(root.right, str + "1", huffmanmap);
    }
    public int decode(tNode root, int i, StringBuilder sb){
        if(root == null)
            return i;
        if(root.left == null && root.right == null){
            System.out.print(root.c);
            return i;
        }
        i++;
        if(sb.charAt(i) == '0')
            i = decode(root.left, i, sb);
        else
            i = decode(root.right, i, sb);
        return i;
    }

    public void huffmanTree(StringBuilder tobeDecoded, HashMap<Character, Integer> map) {
        //PriorityQueue<tNode> pq = new PriorityQueue<>((l, r) -> r.f - l.f);
        priorityMaxQueue pq = new priorityMaxQueue();
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new tNode(entry.getKey(), entry.getValue()));
        }

        while(pq.size() != 1) {
            //pq.print();
            tNode left = pq.getMax();
            //pq.print();
            tNode right = pq.getMax();
            int ans = left.f + right.f;
            pq.add(new tNode('\0', ans, right, left));
        }

        tNode root = pq.max();
//        Map<Character, String> huffmanmap = new HashMap<>();
//        encoding(root, "", huffmanmap);
//        for(Character a : huffmanmap.keySet()){
//            System.out.println(a + "   " + huffmanmap.get(a));
//        }


        int index = -1;
        while (index < tobeDecoded.length() - 2){
            index = decode(root, index, tobeDecoded);
        }
    }
}

class priorityMaxQueue{
    private tNode[] elements;
    int size;

    public priorityMaxQueue(int capacity) {
        this.elements = new tNode[capacity + 1];
        this.size = 0;
    }

    public priorityMaxQueue() {
        this(1);
    }
    public priorityMaxQueue(tNode[] keys) {
        size = keys.length;
        this.elements = new tNode[keys.length + 1];
        for(int i = 0; i < size; i++) {
            this.elements[i+1] = keys[i];
        }
        for(int k = size/2; k >= 1; k--)
            sink(k);
        assert isMaxHeap();
    }
    public int size(){
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
    public tNode max() {
        return this.elements[1];
    }
    public void resize(int capacity) {
        assert capacity > size;
        tNode[] temp = new tNode[capacity];
        for(int i = 1; i <= this.size; i++)
            temp[i] = this.elements[i];
        this.elements = temp;
    }
    public void add(tNode x) {
        if(size >= elements.length - 1)
            resize(2*elements.length);
        elements[++size] = x;
        bubbleUp(size);
        assert isMaxHeap();
    }
    public tNode getMax() {
        tNode max = elements[1];
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
        int fr = this.elements[i].f - this.elements[j].f;
        if(fr < 0)
            return true;
        else if(fr == 0) {
            return this.elements[i].c - '0' < this.elements[j].c - '0';
        }else
            return false;
    }
    private void swap(int i, int j) {
        tNode temp = this.elements[i];
        this.elements[i] = this.elements[j];
        this.elements[j] = temp;
    }
    public void print() {
        for(int i = 1; i <= size; i++)
            System.out.print(elements[i].c + " " + elements[i].f);
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

class tNode{
    char c;
    int f;
    tNode left;
    tNode right;
    public tNode(char c, int f){
        this.c = c;
        this.f = f;
    }
    public tNode(char ch, int i, tNode l, tNode r){
        this.c = ch;
        this.f = i;
        this.left = l;
        this.right = r;
    }
}
