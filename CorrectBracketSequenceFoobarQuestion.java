import java.util.Scanner;
import java.util.Stack;

public class CorrectBracketSequenceFoobarQuestion {
    public static int operationsForCorrectBrackets(String s){
        int n = s.length();
        if(n%2 != 0)
            return -1;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == ')' && !stack.isEmpty()){
                if(stack.peek() == '(')
                    stack.pop();
                else
                    stack.push(c);
            }else
                stack.push(c);
        }
        int SizeOfStack = stack.size();
        int res = 0;
        while (!stack.isEmpty() && stack.peek() == '('){
            stack.pop();
            res++;
        }
        return SizeOfStack + res;
    }

    public static int minOperations(String s){
        char[] ar = s.toCharArray();
        int left = 0, right = 0;
        int swap = 0, unbalanced = 0;
        for(int i = 0; i < ar.length; i++){
            if(ar[i] == '('){
                left++;
                if(unbalanced > 0) {
                    swap += unbalanced;
                    unbalanced--;
                }
            }else if(ar[i] == ')'){
                right++;
                unbalanced = right - left;
            }
        }
        return swap;
    }

    public static int reorderOfBrackets(String s){
        int n = s.length();
        if(n%2 != 0)
            return -1;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int left = 0, right = 0;
            for(int j = i; j < n; j += 2){
                if(s.charAt(j) == '(')
                    left++;
                else
                    right++;
                if(left == right){
                    if(validParentheses(s.substring(i,j))){
                        i = j - 1;
                        break;
                    }else{
                        ans += s.substring(i,j).length();
                        i = j - 1;
                        break;
                    }
                }
            }
        }

        return ans;
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

    public static int CostOfBalancing(String s){
        int n = s.length();
        if(n == 0)
            return 0;
        int ans = 0;
        int left = 0, right = 0;
        for(int i =  0; i < n; i++){
            if(s.charAt(i) == '(')
                left++;
            else
                right++;
        }
        if(left != right || n%2 != 0)
            return -1;
        int[] ar = new int[n];
        if(s.charAt(0) == '(')
            ar[0] = 1;
        else
            ar[0] = -1;
        if(ar[0] < 0)
            ans += Math.abs(ar[0]);
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == '(')
                ar[i] = ar[i-1] + 1;
            else
                ar[i] = ar[i-1] - 1;
            if(ar[i] < 0)
                ans += Math.abs(ar[i]);
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

         */
        String s = "))((())(";
        int result = CostOfBalancing(s);//reorderOfBrackets(s) ;//minOperations(s); //operationsForCorrectBrackets(s);
        System.out.println(result);
    }
}
