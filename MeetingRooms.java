
public class MeetingRooms {
    public static boolean attendAll(int[][] interval){
        if(interval == null || interval.length == 0 || interval[0].length != 2)
            return false;
        int[] startAr = new int[interval.length];
        int[] endAr = new int[interval.length];
        for(int i = 0; i < interval.length; i++){
            startAr[i] = interval[i][0];
            endAr[i] = interval[i][1];
        }
        return true;
    }

    public static boolean attendMeetig(int[][] intervals){
        if(intervals == null ||intervals.length == 0 || intervals[0].length != 2)
            return false;
        boolean flag = true;
        for(int[] a : intervals){
            for(int i = 0; i < intervals.length; i++){
                if(intervals[i] != a){
                    if(intervals[i][0] > a[0] && intervals[i][0] <= a[1] || intervals[i][0] > a[0] && intervals[i][1] <= a[1]) {
                        flag = false;
                        break;
                    }
                }
            }
        }
        System.out.println(flag);
        return flag;
    }

    public static void main(String[] args){
        int[][] interval= {{0,30},{5,10},{15,20}};
        attendMeetig(interval);
        //attendAll(interval);
    }
}
