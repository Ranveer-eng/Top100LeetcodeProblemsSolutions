public class RegularExpMatching {

    public static boolean isMatch(String s, String p){
        return s.matches(p);
    }

    public static boolean isMatches(String s, String p){//s = "aab", p = "c*a*b"
        if(p.length() == 0)
            return s.length() == 0;
        if(p.length() == 1){
            if(s.length() < 1 || p.charAt(0) == '*')
                return false;
            if(p.charAt(0) == '.')
                return s.length() == 1;
            else
                return s.charAt(0) == p.charAt(0);
        }else{
            if(p.charAt(p.length()-1) == s.charAt(s.length() - 1) || p.charAt(p.length() - 1) == '.' || p.charAt(p.length()-1) == '*')
                isMatches(s.substring(0,s.length() - 1), p.substring(0,p.length() - 1));
            return false;
        }
    }

    public static boolean isPatternMatch(String s, String p){
        if(p.length() == 0)
            return s.length() == 0;
        boolean c = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        if(p.length() >= 2 && p.charAt(1) == '*')
            return (isPatternMatch(s,p.substring(2)) || (c && isPatternMatch(s.substring(1), p)));
        else
            return (c && isPatternMatch(s.substring(1), p.substring(1)));
    }

    public static void main(String[] args){
        String s = "mississippi", p = "mis*is*p*.";
        //p = "aadc*b"; s = "aab";
        boolean test = false, test1 = false;
        test = isMatch(s,p);
        //test1 = isMatches(s, p);
        test1 = isPatternMatch(s,p);


        System.out.println(test);
        System.out.println(test1);
    }
}
