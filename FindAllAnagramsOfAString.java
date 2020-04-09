import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsOfAString {
    public static List<Integer> allAnagrams(String s, String p){
        char[] cAr = p.toCharArray();
        Arrays.sort(cAr);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length() - p.length() + 1; i++){
            String t = s.substring(i, i + p.length());
            if(isAnagram(cAr, t))
                list.add(i);
        }
        System.out.println(list);
        return list;
    }
    private static boolean isAnagram(char[] cAr, String t){
        char[] ccArr = t.toCharArray();
        Arrays.sort(ccArr);
        return Arrays.equals(ccArr, cAr);
    }

    public static void main(String[] args){
        String s = "abab", p = "ab";
        allAnagrams(s, p);
    }
}
