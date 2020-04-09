public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] ar1, int[] ar2){
        int n1 = ar1.length, n2 = ar2.length;
        int i = 0, j = 0, k = 0;
        double res = 0;
        int[] ar = new int[n1 + n2];
        while(i < n1 && j < n2 && k <= (n1+n2)/2){
            if(ar1[i] < ar2[j]){
                ar[k] = ar1[i];
                i++;
            }else{
                ar[k] = ar2[j];
                j++;
            }
            k++;
        }
        if(k == (n1+n2)/2 + 1){
            if((n1+n2)%2 == 0){
                res = ((double) (ar[k] + ar[k-1]))/2;
            }else{
                res = ((double) (ar[k-1]));
            }
            System.out.println(res);
            return res;
        }
        while (i < n1){
            ar[k] = ar1[i];
            i++;
            k++;
        }
        while (j < n2){
            ar[k] = ar2[j];
            j++;
            k++;
        }
        if((n1 + n2) %2 == 0){
            res = ((double) (ar[(n1+n2)/2] + ar[(n1+n2)/2 - 1])/2);
        }else{
            res = ar[(n1+n2)/2];
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        int[] ar1 = {1,2,2,3,4,5};
        int[] ar2 = {2,3,3};
        findMedianSortedArrays(ar1, ar2);
        //findMedianOfTwoArrays(ar1, ar2);
    }
}
