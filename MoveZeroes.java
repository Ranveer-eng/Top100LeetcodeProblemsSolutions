public class MoveZeroes {
    public static int[] moveToEnd(int[] num){
        if(num == null || num.length <= 1)
            return num;
        int i = 0, j = 0;
        while (j < num.length){
            if(num[i] != 0)
                i++;
            if(num[j] == 0)
                j++;
            else{
                num[i] = num[j];
                num[j] = 0;
                i++;
                j++;
            }
        }
        printArray(num);
        return num;
    }
    public static void printArray(int[] num){
        for(int a : num){
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] num = {0,1,0,3,12};
        moveToEnd(num);
    }
}
