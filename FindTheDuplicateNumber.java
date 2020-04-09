public class FindTheDuplicateNumber {
    public static int duplicate(int[] num){
        String s = " ";
        int ans = -1;
        for(int a : num){
            if(!s.contains(" "+a+ " ")){
                s = s + a + " ";
            }else {
                ans = a;
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static int findDup(int[] num){
        int ans = 0;
        int i = 0,j = 0;
        do {
            i = num[i];
            j = num[num[j]];
        }while (i != j);
        while (ans != i){
            i = num[i];
            ans = num[ans];
        }
        System.out.println(ans);
        return ans;
    }


    public static void main(String[] args) {
        int[] num = {3,1,3,4,2};
        duplicate(num);                                                     //String Method
        findDup(num);
    }
}
