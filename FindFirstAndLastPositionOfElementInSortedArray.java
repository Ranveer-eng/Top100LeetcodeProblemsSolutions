
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] num, int target){
        int[] res = {-1,-1};
        int start = 0, end = 0;
        res[0] = searchSlightSmall(num, 0, num.length-1, target);
        res[1] = searchSlightlyGreat(num, 0, num.length-1, target);
        System.out.println(res[0] + " " + res[1]);
        return res;
    }
    private static int searchSlightlyGreat(int[] num, int start, int end, int target){
        if(start > end)
            return -1;
        int mid = (start + end)/2;
        if(num[mid] == target){
            if(mid +1 == num.length)
                return mid;
            if(mid+1 != num.length && num[mid+1] != target)
                return mid;
            else
                return searchSlightlyGreat(num, mid + 1, end, target);
        }
        if(num[mid] < target){
            return searchSlightlyGreat(num, mid+1, end, target);
        }else {
            return searchSlightlyGreat(num, start, mid - 1, target);
        }
    }
    private static int searchSlightSmall(int[] num, int start, int end, int target){
        if(start > end)
            return -1;
        int mid = (start + end)/2;
        if(num[mid] == target){
            if(num[mid-1] != target)
                return mid;
            else
                return searchSlightSmall(num, start, mid-1, target);
        }
        if(num[mid] < target){
            return searchSlightSmall(num, mid+1, end, target);
        }else{
            return searchSlightSmall(num, start, mid-1, target);
        }
    }

    public static int[] searchRangeIndex(int[] num, int target){
        int[] res = {-1,-1};
        res[0] = bsearch(num, target, -1);
        res[1] = bsearch(num, target, 1);
        System.out.println(res[0] + " " + res[1]);
        return res;
    }
    private static int bsearch(int[] num, int target, int cmp){
        int l = 0;
        int r = num.length - 1;
        int pos = -1;
        while (l <= r){
            int mid = l + (r-l)/2;
            if(num[mid] > target){
                r = mid-1;
            }else if(num[mid] < target){
                l = mid+1;
            }else {
                pos = mid;
                if(cmp < 0)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return pos;
    }

    public static void main(String[] args){
        int[] num = {5,7,7,8,8,10};
        int target = 10;
        searchRange(num, target);
        searchRangeIndex(num, target);
    }
}
