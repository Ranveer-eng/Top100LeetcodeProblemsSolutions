import java.util.Scanner;

public class StubbornMehak {
    public static int[] jumps = new int[1501];
    public static int mehakStairs(int[] ar, int i, String s){
        if(i >= ar.length)
            return 10000000;
        if(i == ar.length - 1)
            return 0;
        else{
            int ans = 0;
            if(!s.contains(" " + (i+ar[i]) + " ")){
                ans = mehakStairs(ar, i+ar[i], s + (i+ar[i]) + " ");
            }else{
                ans = 10000000;
            }
            return Math.min(ans, mehakStairs(ar, i+1, s + (i+1) + " ")) + 1;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            int[] ar = new int[n+1];
            for(int j = 0; j < n; j++){
                ar[j] = sc.nextInt();
            }
            ar[n] = 0;
            int res = mehakStairs(ar, 0, " ");
            System.out.println(res);
        }

    }
}
