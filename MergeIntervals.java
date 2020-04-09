import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] interval){
        List<int[]> res = new ArrayList<>();
        Arrays.sort(interval, (a,b) ->a[0] - b[0]);
        int start = Integer.MIN_VALUE, end = start;
        for(int[] i : interval){
            if(i[0] > end){
                if(start > Integer.MIN_VALUE)
                    res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }else {
                end = Math.max(end, i[1]);
            }
        }
        if(start > Integer.MIN_VALUE)
            res.add(new int[] {start, end});
        int[][] ans = res.toArray(new int[][]{});
        print2DArray(ans);
        return ans;
    }
    private static void print2DArray(int[][] num){
        for(int i = 0; i < num.length; i++){
            System.out.print("("+num[i][0] + "," + num[i][1] + ") " );
        }
        System.out.println();
    }

    public static int[][] mergeOverlap(int[][] num){
        List<int[]> list = new ArrayList<>();
        String s = "";
        for(int i = 0; i < num.length; i++){
            if(!s.contains((num[i][0]) + "" + (num[i][1]))) {
                for (int j = i + 1; j < num.length; j++) {
                    if (num[i][1] >= num[j][0] && num[i][0] < num[j][0]) {
                        s += num[j][0] + "" + num[j][1];
                        list.add(new int[]{num[i][0], num[j][1]});
                    }
                }
            }
        }
        int[][] res = list.toArray(new int[][]{});
        print2DArray(res);
        return res;
    }

    public static void main(String[] args){
        int[][] interval = {{8,10},{1,3},{15,18},{2,6}};
        merge(interval);
        mergeOverlap(interval);
    }
}
