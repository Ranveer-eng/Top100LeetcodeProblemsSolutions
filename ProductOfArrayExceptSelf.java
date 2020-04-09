public class ProductOfArrayExceptSelf {
    public static int[] product(int[] num){
        if(num == null || num.length <= 1)
            return new int[1];
        int[] list = new int[num.length];
        int allPro = 1;boolean zero = false;int j = 0, index = -1;
        for(int i = 0; i < num.length; i++){
            if(num[i] != 0)
                allPro *= num[i];
            else {
                zero = true;
                j++;
                index = i;
            }
        }
        if(zero && j > 1)
            return list;
        if(!zero) {
            for (int i = 0; i < num.length; i++) {
                list[i] = allPro/num[i];
            }
        }else {
            for(int i = 0; i < num.length; i++){
                if(i != index)
                    list[i] = 0;
                else
                    list[i] = allPro;
            }
        }
        printArray(list);
        return list;
    }

    public static void printArray(int[] num){
        for(int i = 0; i < num.length; i++){
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }

    public static int[] productWithoutDivision(int[] num){
        int[] list = new int[num.length];
        int[] left = new int[num.length];
        int[] right = new int[num.length];
        for(int i = 0; i < num.length; i++){
            if(i == 0)
                left[i] = 1;
            else
                left[i] =left[i-1]*num[i-1];
        }
        //printArray(left);
        for(int i = num.length-1; i >= 0; i--){
            if(i == num.length - 1)
                right[i] = 1;
            else
                right[i] =right[i+1]*num[i+1];
        }
        //printArray(right);
        for(int i = 0; i < num.length; i++){
            list[i] = left[i]*right[i];
        }
        printArray(list);
        return list;
    }

    public static int[] productInPlace(int[] num){
        int n = num.length;
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            if(i == 0)
                list[i] = 1;
            else
                list[i] = list[i-1]*num[i-1];
        }
        int pro = 1;
        for(int i = n-1; i>=0; i--){
            list[i] = list[i]*pro;
            pro *= num[i];
        }
        printArray(list);
        return list;
    }

    public static void main(String[] args){
        int[] num = /*{1,4,7,2};*/{1,2,3,4};
        product(num);
        productWithoutDivision(num);
        productInPlace(num);
    }
}
