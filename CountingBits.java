public class CountingBits {
    public static int[] countBits(int n){
        int[] num = new int[n + 1];
        for(int i = 0; i <= n; i++){
//            int sqrt = (int) Math.sqrt(i);
            num[i] = getNumbersOfTwoPowers(i);
        }
        printArray(num);
        return num;
    }
    private static void printArray(int[] num){
        for(int a : num){
            System.out.print(a + " ");
        }
        System.out.println();
        return;
    }
    private static int getNumbersOfTwoPowers(int n){
        int bits = 0;
        while (n != 0){
            bits += n % 2;
            n = n / 2;
        }
        return bits;
    }

    public static int[] countingBits(int n){
        if( n <= 0)
            return new int[0];
        int[] bits = new int[n + 1];
        bits[0] = 0; bits[1] = 1;
        for(int i = 2; i <= n; i++){
            int ans = i%2;
            ans += bits[i/2];
            bits[i] = ans;
        }
        printArray(bits);
        return bits;
    }



    public static void main(String[] args){
        int n = 5;
        countBits(n);
        countingBits(n);
    }
}
