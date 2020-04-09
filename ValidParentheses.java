import java.util.Stack;

public class ValidParentheses {
    public static boolean validParentheses(String s){
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

    public static void main(String[] args){
        boolean test = validParentheses("[{}]");
        System.out.println(test);
    }
}
