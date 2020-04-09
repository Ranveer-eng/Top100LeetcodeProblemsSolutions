import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class huffmanCompression2 {

    public static void main(String[] args) {
        huffman2 huff = new huffman2();
        Scanner sc = new Scanner(System.in);
        //String s = sc.nextLine();
        //String s = "aaaabccd";
        //String decoded = "111111111111011011010";

        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            HashMap<Character, Integer> map = new HashMap<>();
            int n = sc.nextInt();
            sc.nextLine();
            for(int j = 0; j < n; j++){
                String cs = sc.nextLine();
                map.put(cs.charAt(0), Integer.parseInt(cs.substring(2))+1);
            }
            String decoded = sc.nextLine();
            StringBuilder decode = new StringBuilder(decoded);
            huff.huffmanTree(decode, map);
            System.out.println();
        }

    }
}

class huffman2{
    public void encoding(treeNode root, String str, Map<Character, String> huffmanmap) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            huffmanmap.put(root.c, str);

        encoding(root.left, str + "1", huffmanmap);
        encoding(root.right, str + "0", huffmanmap);
    }
    public int decode(treeNode2 root, int i, StringBuilder sb){
        if(root == null)
            return i;
        if(root.left == null && root.right == null){
            System.out.print(root.c);
            return i;
        }
        i++;
        if(sb.charAt(i) == '0')
            i = decode(root.right, i, sb);
        else
            i = decode(root.left, i, sb);
        return i;
    }

    public void huffmanTree(StringBuilder tobeDecoded, HashMap<Character, Integer> map) {
        PriorityQueue<treeNode2> pq = new PriorityQueue<>((l, r) -> r.f - l.f);

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new treeNode2(entry.getKey(), entry.getValue()));
        }

        while(pq.size() != 1) {
            treeNode2 left = pq.poll();
            treeNode2 right = pq.poll();
            int ans = left.f + right.f;
            pq.add(new treeNode2('\0', ans, left, right));
        }

        treeNode2 root = pq.peek();

        //Map<Character, String> huffmanmap = new HashMap<>();
        //encoding(root, "", huffmanmap);
		/*
		char[] strChar = s.toCharArray();
		Arrays.sort(strChar);

		for(int i = 0; i < s.length(); i++) {
			System.out.println(huffmanmap.get(strChar[i]));
		}
		*/
//        for(Map.Entry<Character, String> entry : huffmanmap.entrySet()){
//            System.out.println(entry.getValue());
//        }

        int index = -1;
        while (index < tobeDecoded.length() - 2){
            index = decode(root, index, tobeDecoded);
        }
    }
}

class treeNode2{
    char c;
    int f;
    treeNode2 left = null;
    treeNode2 right = null;

    public treeNode2(char c, int f){
        this.c = c;
        this.f = f;
    }

    public treeNode2(char c, int f, treeNode2 l, treeNode2 r) {
        this.c = c;
        this.f = f;
        this.left = l;
        this.right = r;
    }
}