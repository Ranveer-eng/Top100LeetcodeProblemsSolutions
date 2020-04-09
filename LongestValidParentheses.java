import java.util.Stack;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s){
        if(s == null || s.length() <= 1)
            return 0;
        if(s.length() == 2)
            return s.charAt(0) == s.charAt(1) ? 2 : 0;
        int res = 0;
        res = getLengthOfMaxValidParen(s, 0, s.length() - 1, s.length());
        System.out.println(res);
        return res;
    }
    private static int getLengthOfMaxValidParen(String s, int start, int end, int length){
        if(start >= end || s.length() == 0 || start >= s.length() || end <= 0){
            return 0;
        }
        if(validParentheses(s.substring(start, end+1))){
            return length;
        }else if(s.length() <= 2){
            return 0;
        }else {
            int ans = Math.max( getLengthOfMaxValidParen(s, start, end-1, length-1), getLengthOfMaxValidParen(s, start+1, end, length-1));
            ans = Math.max(ans, getLengthOfMaxValidParen(s, start+1, end - 1, length-2));
            return ans;
        }
    }
    private static boolean validParentheses(String s){
        if(s.length() %2 != 0)
            return false;
        Stack stack = new Stack();
        for(char c : s.toCharArray()){
            switch (c){
                case ')':
                    if(stack.isEmpty() || stack.pop() != (Object) '(')
                        return false;
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != (Object) '{')
                        return false;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != (Object) '[')
                        return false;
                    break;
                default:
                    stack.push(c);
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
    public static int longestValidParenthesesUsingStack(String s){
        Stack<int[]> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                if(!stack.isEmpty() && stack.peek()[0] == 0){
                    stack.pop();
                    res = Math.max(res, i - (stack.isEmpty() ? -1: stack.peek()[1]));
                }else {
                    stack.push(new int[]{1, i});
                }
            }else {
                stack.push(new int[] {0, i});
            }
        }
        System.out.println(res);
        return res;
    }

    public static int longestValidParen(String s){
        if(s.length() <= 1)
            return 0;
        Stack stack = new Stack();
        int res = 0, best = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c== '('){
                stack.push(c);
            }else if(stack.isEmpty()){
                res = 0;
            }else {
                stack.pop();
                res += 2;
                if(stack.isEmpty()){
                    best = Math.max(res, best);
                }
            }
        }
        System.out.println(best);
        return best;
    }

    public static void main(String[] args){
        longestValidParentheses(")()())");                                  //Brute Recursive Approach
        longestValidParenthesesUsingStack(")()())");
        longestValidParen(")()())");
    }
}
