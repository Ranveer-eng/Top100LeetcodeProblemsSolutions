import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagram(String[] str){
        List<List<String>> list = new ArrayList<>();
        if(str.length <= 0){
            return list;
        }
        String ar = new String();
        for(int i = 0; i < str.length; i++){
            if(!ar.contains(str[i])){
                ar += str[i];
                List<String> l = new ArrayList<>();
                for(int j = i+1; j < str.length; j++){
                    boolean flag = true;
                    for(char a : str[i].toCharArray()){
                        if(!str[j].contains(String.valueOf(a))){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        l.add(str[j]);
                        ar += str[j];
                    }
                }
                l.add(str[i]);
                list.add(l);
            }
        }
        System.out.println(list);
        return list;
    }

    public static List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String str: strs){
            char[] arr = new char[26];
            for(int i = 0; i <str.length(); i++){
                arr[str.charAt(i) - 'a']++;
            }
            String ns = new String(arr);
            if(map.containsKey(ns)){
                map.get(ns).add(str);
            }else {
                ArrayList<String> al = new ArrayList<>();
                al.add(str);
                map.put(ns, al);
            }
        }
        res.addAll(map.values());
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        String[] gr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagram(gr);
        groupAnagrams(gr);
    }
}
