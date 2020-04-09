import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class huffmanCompression {

    public static void main(String[] args) {
        huffman huff = new huffman();
        Scanner sc = new Scanner(System.in);
        //String s = sc.nextLine();
        String s = "aaaabccd";
        String decoded = "111111111111011011010";
        StringBuilder decode = new StringBuilder(decoded);
        huff.huffmanTree(s, decode);
    }
}

class huffman{
    public void encoding(treeNode root, String str, Map<Character, String> huffmanmap) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            huffmanmap.put(root.c, str);

        encoding(root.left, str + "1", huffmanmap);
        encoding(root.right, str + "0", huffmanmap);
    }
    public int decode(treeNode root, int i, StringBuilder sb){
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

    public void huffmanTree(String s, StringBuilder tobeDecoded) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), 0);
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }

        PriorityQueue<treeNode> pq = new PriorityQueue<>((l, r) -> r.f - l.f);

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new treeNode(entry.getKey(), entry.getValue()));
        }

        while(pq.size() != 1) {
            treeNode left = pq.poll();
            treeNode right = pq.poll();
            int ans = left.f + right.f;
            pq.add(new treeNode('\0', ans, left, right));
        }

        treeNode root = pq.peek();

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

class treeNode{
    char c;
    int f;
    treeNode left = null;
    treeNode right = null;

    public treeNode(char c, int f){
        this.c = c;
        this.f = f;
    }

    public treeNode(char c, int f, treeNode l, treeNode r) {
        this.c = c;
        this.f = f;
        this.left = l;
        this.right = r;
    }
}