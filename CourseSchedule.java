import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule {
    public static HashMap<Integer, List<Integer>> map = new HashMap<>();
    public static boolean canFinish(int numCourse , int[][] pre){
        for(int[] p : pre){
            if(checkCycle(p[0], p[1])){
                if(map.containsKey(pre[0])){
                    map.get(p[0]).add(p[1]);
                }else {
                    map.put(p[0], new ArrayList<Integer>());
                    map.get(p[0]).add(p[1]);
                }
            }else {
                System.out.println(false);
                return false;
            }
        }
        System.out.println(true);
        return true;
    }
    private static boolean checkCycle(int i, int j){
        if(map.containsKey(j)){
            if(map.get(j).contains(i))
                return false;
            for(int k : map.get(j)){
                if(!checkCycle(i, j))
                    return false;
            }
            return true;
        }else
            return true;
    }

    public static void main(String[] args){
        int numCourses = 2;
        int[][] prerequisite = {{0,1}};
        canFinish(numCourses, prerequisite);
    }
}
