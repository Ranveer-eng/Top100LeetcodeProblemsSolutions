import java.util.HashMap;

public class LongestSubStringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstringNormal(String s){
        if(s.length() <= 1){
            return s.length();
        }
        int res = 1;
        int n = s.length();
        for(int i = 0; i < n; i++){
            int max = 1;
            for(int j = i+1; j < n; j++){
                if(!s.substring(i,j).contains(s.substring(j,j+1))){
                    max++;
                    if(res < max){
                        res = max;
                    }
                }else {
                    break;
                }
            }
        }
        System.out.println(res);
        return res;
    }

    public static int lengthOfLongestSubstring(String s){
        int n = s.length();
        if(n <= 1){
            return n;
        }
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        for(int j = 0; j < n; j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            res = Math.max(res, j-i+1);
            map.put(s.charAt(j), j+1);
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        lengthOfLongestSubstringNormal("pwwkew"); //O(n^3) --> Brute Force
        lengthOfLongestSubstring("pwwkew");       //O(n)   --> HashMap
    }
}
