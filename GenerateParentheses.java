import java.util.*;

public class GenerateParentheses {

    public static List<String> generateParentheses(int n){
        List<String> list = new ArrayList<>();
        if(n <= 0)
            return list;
        char[] parentheses = {'(',')'};
        createParentheses(parentheses, list, 2*n, "");
        System.out.println(list);
        return list;
    }
    private static void createParentheses(char[] parentheses, List<String> list, int n, String s){
        if(n == 0){
            if(validParentheses(s))
                list.add(s);
            return;
        }else {
            for(char c : parentheses){
                createParentheses(parentheses, list, n-1, s + c);
            }
        }
    }

    private static boolean validParentheses(String s) {
        if (s.length() % 2 != 0 || s.length() == 0)
            return false;
        Stack stack = new Stack();
        for (char c : s.toCharArray()) {
            switch (c) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != (Object) '(')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != (Object) '{')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != (Object) '[')
                        return false;
                    break;
                default:
                    stack.push(c);
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }

    public static List<String> generateParenthesesUsingConfinedRecursion(int n){
        List<String> list = new ArrayList<>();
        if(n <= 0)
            return list;
        nMatchedParentheses(list, "", n, n);
        System.out.println(list);
        return list;
    }
    private static void nMatchedParentheses(List<String> list, String s, int open, int close){
        if(open == close && open == 0){
            list.add(s);
            return;
        }else if(open == close){
            nMatchedParentheses(list, s + '(', open - 1, close);
        }else if(open == 0){
            nMatchedParentheses(list, s + ')', open, close - 1);
        }else if(open < close){
            nMatchedParentheses(list, s + '(', open - 1, close);
            nMatchedParentheses(list, s + ')', open, close - 1);
        }
    }

    public static List<String> generateParen(int n){
        ArrayList<String> list = new ArrayList<>();
        dfs(list, "", n, n);
        System.out.println(list);
        return list;
    }
    private static void dfs(ArrayList<String> list, String s, int left, int right){
        if(left > right)
            return;
        if(left == 0 && right == 0){
            list.add(s);
            return;
        }
        if(left > 0)
            dfs(list, s + "(", left - 1, right);
        if(right > 0)
            dfs(list, s + ")", left, right - 1);
    }

    public static List<String> generateParenthesesUsingBFS(int n){
        //ArrayList<String> list = new ArrayList<>();
        if(n <= 0)
            return new ArrayList<String>();
        if(n == 1)
            return new ArrayList<String>(Arrays.asList("()"));
        Set<String> set = new HashSet<>();
        for(String str : generateParenthesesUsingBFS(n-1)){
            for(int i = 0; i < str.length(); i++){
                set.add(str.substring(0,i+1) + "()" + str.substring(i+1, str.length()));
            }
        }
        //System.out.println(new ArrayList<String>(set));
        return new ArrayList<String>(set);
    }

    public static List<String> generateParenthesesUsingCloseApproach(int n){
        List<String> ans = new ArrayList<>();
        if(n <= 0) {
            ans.add("");
        }else {
            for(int i = 0; i < n; ++i){
                for(String left : generateParenthesesUsingCloseApproach(i)){
                    for(String right : generateParenthesesUsingCloseApproach(n - 1- i)){
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
            return ans;
        }
        return ans;
    }

    public static void main(String[] args){
        generateParentheses(3);                             //Brute Force
        generateParenthesesUsingConfinedRecursion(3);       //Recursion
        generateParen(3);                                   //DFS
        generateParenthesesUsingBFS(3);                     //BFS
        List<String> list = generateParenthesesUsingCloseApproach(3);           //Close Character Approach
        System.out.println(list);
    }
}
