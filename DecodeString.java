import java.util.Stack;

public class DecodeString {
    public static String decodeMyString(String s){
        Stack<Integer> stOfInt = new Stack<>();
        Stack<String> stOfString = new Stack<>();
        String res = "";
        int i = 0;
        while (i < s.length()){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                int num = 0;
                while (s.charAt(i) <= '9' && s.charAt(i) >= '0'){
                    num += s.charAt(i) - '0';
                    num *= 10;
                    i++;
                }
                num /= 10;
                stOfInt.push(num);
                continue;
            }
            switch (s.charAt(i)){
                case '[':
                    stOfString.push(res);
                    res = "";
                    break;
                case ']':
                    String str = stOfString.pop();
                    int num = stOfInt.pop();
                    String temp = "";
                    for(int j = 0; j < num; j++)
                        temp += res;
                    res = str + temp;
                    break;
                default:
                    res += String.valueOf(s.charAt(i));
            }
            i++;
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        String st = "3[a]2[bc]";
        decodeMyString(st);
    }
}
