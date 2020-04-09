import com.sun.org.apache.xpath.internal.objects.XObject;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public static List<Integer> disappear(int[] num){
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= num.length; i++)
            list.add(i);
        for(int a : num){
            if(list.contains(a))
                list.remove((Object) a);
        }
        System.out.println(list);
        return list;
    }

    public static void main(String[] args){
        int[] num = {4,3,2,7,8,2,3,1};
        disappear(num);
    }
}
