import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class huffmanCompression1 {

    public static void main(String[] args) {
        huffman1 huff = new huffman1();
        Scanner sc = new Scanner(System.in);
        //String s = sc.nextLine();
        int[] s = new int[256];int j = 0;

        huff.huffmanTree(s);
    }
}

class huffman1{
    public void encoding(treeNode1 root, String str, Map<Integer, String> huffmanmap) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            huffmanmap.put(root.c, str);

        encoding(root.left, str + "0", huffmanmap);
        encoding(root.right, str + "1", huffmanmap);
    }

    public void huffmanTree(int[] s) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length; i++) {
            if(!map.containsKey(s[i]))
                map.put(s[i], 0);
            map.put(s[i], map.get(s[i]) + 1);
        }

        PriorityQueue<treeNode1> pq = new PriorityQueue<>((l, r) -> l.f - r.f);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new treeNode1(entry.getKey(), entry.getValue()));
        }

        while(pq.size() != 1) {
            treeNode1 left = pq.poll();
            treeNode1 right = pq.poll();
            int ans = left.f + right.f;
            pq.add(new treeNode1('\0', ans, left, right));
        }

        treeNode1 root = pq.peek();

        Map<Integer, String> huffmanmap = new HashMap<>();
        encoding(root, "", huffmanmap);
		/*
		char[] strChar = s.toCharArray();
		Arrays.sort(strChar);

		for(int i = 0; i < s.length(); i++) {
			System.out.println(huffmanmap.get(strChar[i]));
		}
		*/
        for(Map.Entry<Integer, String> entry : huffmanmap.entrySet()){
            System.out.println(entry.getValue());
        }

    }
}

class treeNode1{
    int c;
    int f;
    treeNode1 left = null;
    treeNode1 right = null;

    public treeNode1(int c, int f){
        this.c = c;
        this.f = f;
    }

    public treeNode1(int c, int f, treeNode1 l, treeNode1 r) {
        this.c = c;
        this.f = f;
        this.left = l;
        this.right = r;
    }
}