public class SearchInRotatedSortedArray {
    public static int searchInArray(int[] num, int target){
        int index = -1;
        int start = 0, end = num.length - 1;
        while (start <= end){
            int mid = (start + end)/2;
            if(num[mid] == target){
                index = mid;
                break;
            }else if(num[start] <= num[mid] && target < num[mid] && target >= num[start]){
                end = mid;
            }else if(num[start] <= num[mid] && target < num[mid] && target < num[start]){
                start = mid+1;
            }else if(num[start] <= num[mid] && target > num[mid]){
                start = mid+1;
            }else if(num[start] >= num[mid] && target < num[mid]){
                end = mid;
            }else if(num[start] >= num[mid] && target > num[mid]){
                if(target >= num[start])
                    end = mid;
                else
                    start = mid+1;
            }
        }
        System.out.println(index);
        return index;
    }

    public static int searchInSortedRotatedArray(int[] num, int start, int end, int target){
        if(start > end)
            return -1;
        int mid = (start + end)/2;
        if(num[mid] == target)
            return mid;
        if(num[start] <= num[mid]){
            if(target >= num[start] && target <= num[mid])
                return searchInSortedRotatedArray(num, start, mid-1, target);
            return searchInSortedRotatedArray(num, mid+1, end, target);
        }
        if(target >= num[mid] && target <= num[end])
            return searchInSortedRotatedArray(num, mid+1, end, target);
        return searchInSortedRotatedArray(num, start, mid-1, target);
    }

    public static void main(String[] args){
        int[] num = {4,5,6,7,0,1,2};
        int target = 1;
        searchInArray(num, target);                                                               //Iterative Approach
        int test = searchInSortedRotatedArray(num, 0, num.length - 1, target);         //Recursion Approach
        System.out.println(test);
    }
}
