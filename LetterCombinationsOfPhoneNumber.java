import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public static List<String> list = new ArrayList<>();

    public static List<String> letterCombination(String digit){
        String ansStr = "";
        for(char c : digit.toCharArray()){
            switch (c){
                case '1':
                    ansStr += " ";
                    break;
                case '2':
                    ansStr += "abc ";
                    break;
                case '3':
                    ansStr += "def ";
                    break;
                case '4':
                    ansStr += "ghi ";
                    break;
                case '5':
                    ansStr += "jkl ";
                    break;
                case '6':
                    ansStr += "mno ";
                    break;
                case '7':
                    ansStr += "pqrs ";
                    break;
                case '8':
                    ansStr += "tuv ";
                    break;
                case '9':
                    ansStr += "wxyz ";
                    break;
            }
        }
        String[] ar = ansStr.split(" ");
        //printStrArray(ar);
        getAllDigitsCom(ar, 0, "");
        System.out.println(list);
        //System.out.println(list.size());
        return list;
    }
    private static void getAllDigitsCom(String[] strAr, int i, String s){
        if(i == strAr.length - 1){
            for(int j = 0; j < strAr[i].length(); j++){
                list.add(s + String.valueOf(strAr[i].charAt(j)));
            }
            return;
        }else {
            for(int j = 0; j < strAr[i].length(); j++){
                getAllDigitsCom(strAr, i+1, s + String.valueOf(strAr[i].charAt(j)));
            }
        }
    }

    public static List<String> letterComb(String digit){
        List<String> res = new ArrayList<String>();
        HashMap<Character, char[]> hash = new HashMap<>();
        hash.put('2', new char[] {'a', 'b','c'});
        hash.put('3', new char[] {'d', 'e','f'});
        hash.put('4', new char[] {'g', 'h','i'});
        hash.put('5', new char[] {'j', 'k','l'});
        hash.put('6', new char[] {'m', 'n','o'});
        hash.put('7', new char[] {'p', 'q', 'r', 's'});
        hash.put('8', new char[] {'t', 'u','v'});
        hash.put('9', new char[] {'w', 'x', 'y', 'z'});
        if(digit == null || digit.length() <= 1){
            if(digit.length() == 1){
                Character c = digit.charAt(0);
                res.add(new String(hash.get(c)));
                return res;
            }
            return res;
        }
        char[] ar = new char[digit.length()];
        helper(digit, 0, hash, res, ar);
        System.out.println(res);
        return res;
    }
    private static void helper(String digits, int index, HashMap<Character, char[]> hash, List<String> res, char[] ar){
        if(index == digits.length()){
            res.add(new String(ar));
            return;
        }
        Character c = digits.charAt(index);
        char[] candidates = hash.get(c);
        for(int i = 0; i < candidates.length; i++){
            ar[index] = candidates[i];
            helper(digits, index + 1, hash, res, ar);
        }
    }

    public static List<String> letterCombinations(String digits){
        List<String> list = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return list;
        HashMap<Character, String> hash = new HashMap<>();
        hash.put('2',"abc");
        hash.put('3', "def");
        hash.put('4', "ghi");
        hash.put('5', "jkl");
        hash.put('6', "mno");
        hash.put('7', "pqrs");
        hash.put('8', "tuv");
        hash.put('9', "wxyz");
        list.add("");
        for(int i = 0; i < digits.length(); i++){
            ArrayList<String> temp = new ArrayList<>();
            String option = hash.get(digits.charAt(i));
            for(int j = 0; j < list.size(); j++){
                for(int k = 0; k < option.length(); k++)
                    temp.add(new StringBuilder(list.get(j)).append(option.charAt(k)).toString());
            }
            list.clear();
            list.addAll(temp);
        }
        System.out.println(list);
        return list;
    }

    public static void printStrArray(String[] str){
        for(int i = 0; i< str.length; i++){
            System.out.print(str[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        String digits = "23";
        letterCombination(digits);                  //Simple Recursion
        letterComb(digits);                         //DFS
        letterCombinations(digits);                 //BFS
    }
}
