import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

    public  static int currentMinWindowStringLength = Integer.MAX_VALUE;
    public static int startIndex = -1, endIndex = -1;
    public static String minWindow(String s, String t){
        if(s == null || s.length() < t.length())
            return "";
        int[] tA = new int[65];
        char[] tcharA = t.toCharArray();
        for(char c : tcharA){
            tA[c - 'A']++;
        }
        int[] sA = new int[65];
        int j = 0;
        char[] sCharA = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            sA[sCharA[i] - 'A']++;
            if(sCharContainsAllString(sA, tA)){
                while (sCharContainsAllString(sA, tA)){
                    sA[sCharA[j] - 'A']--;
                    j++;
                }
                if(i - (j - 1) < currentMinWindowStringLength){
                    currentMinWindowStringLength = i-(j-1);
                    startIndex = j- 1;
                    endIndex = i;
                }
            }
        }
        String ans = s.substring(startIndex, endIndex+1);
        if(startIndex != -1){
            System.out.println(ans);
            return ans;
        }else {
            System.out.println("");
            return "";
        }
    }
    private static boolean sCharContainsAllString(int[] sA, int[] tA){
        for(int i = 0; i < tA.length; i++){
            if(tA[i] != 0 && sA[i] < tA[i])
                return false;
        }
        return true;
    }

    public static String minWindowSub(String s, String t){
        String res = "";
        HashMap<Character, Integer> map = new HashMap<>();
        int mapSize = t.length();
        int minLength = Integer.MAX_VALUE;

        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int p = 0, total = 0;
        HashMap<Character, Integer> hash = new HashMap<>();
        for(int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            if(!map.containsKey(c))
                continue;
            int cnt = hash.getOrDefault(c, 0);
            if(cnt < map.get(c))
                total++;
            hash.put(c, cnt+1);
            if(total == mapSize){
                while (!map.containsKey(s.charAt(p)) || hash.get(s.charAt(p)) > map.get(s.charAt(p))){
                    char a = s.charAt(p);
                    if(map.containsKey(a) && hash.get(a) > map.get(a))
                        hash.put(a, hash.get(a) - 1);
                    p++;
                }
                if(minLength > j - p + 1){
                    minLength = j - p + 1;
                    res = s.substring(p, j + 1);
                }
            }
        }
        System.out.println(res);
        return res;
    }

    public static String minWindowSubString(String s, String t){
        String res = "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0, cnt = t.length(), minst = 0, minLen = Integer.MAX_VALUE;
        while (r < s.length()){
            char c = s.charAt(r++);
            if(map.containsKey(c)){
                map.put(c, map.get(c) -1);
                if(map.get(c) >= 0)
                    cnt--;
            }
            while (l < s.length() && cnt == 0){
                if(minLen > r-1-l+1){
                    minLen = r - l;
                    minst = l;
                }
                char d = s.charAt(l++);
                if(map.containsKey(d)){
                    map.put(d, map.get(d) + 1);
                    if(map.get(d) > 0)
                        cnt++;
                }
            }
        }
        res = minLen < Integer.MAX_VALUE ? s.substring(minst, minst + minLen) : "";
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        String s = "ABECODEBAC", t = "ABC";
        minWindow(s, t);
        minWindowSub(s, t);
        minWindowSubString(s, t);
    }
}
