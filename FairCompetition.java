import java.util.Scanner;

public class FairCompetition {
     public static boolean equivalent(String x, String y){
         return (!convertedString(x).equals(convertedString(y)));
     }
     private static String convertedString(String s){
         if(s.length() == 1){
             return s;
         }
         String a = convertedString(s.substring(0, s.length()/2));
         String b = convertedString(s.substring(s.length()/2));

         return String.valueOf((a + b).compareTo(b + a));
     }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        if(equivalent(a, b)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
