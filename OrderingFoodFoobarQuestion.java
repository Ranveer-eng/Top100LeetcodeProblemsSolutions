import java.util.Scanner;

public class OrderingFoodFoobarQuestion {
    public static int minOrderingFood(int p, int pos, int[] ar){
        int cnt = 0;
        while (pos >= 0){
            if(ar[pos] > p)
                pos--;
            else if(ar[pos] == p){
                cnt++;
                break;
            }else{
                p = p - ar[pos];
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] ar = {1,2,4,8,16,32,64,128,256,512,1024,2048};
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int p = sc.nextInt();
            int res = minOrderingFood(p, ar.length-1, ar);
            System.out.println(res);
        }
        //minOrderingFood(10, 11, ar);
    }
}
