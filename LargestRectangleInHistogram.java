import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangle(int[] height){
        int res = 0, area = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i; j < height.length; j++){
                int min = Integer.MAX_VALUE;
                for(int k = i; k <= j; k++){
                    if(height[k] < min)
                        min = height[k];
                }
                area = (min)*(j-i+1);
                if(area > res)
                    res = area;
            }
        }
        System.out.println(res);
        return res;
    }

    public static int largestRect(int[] height){
        int res = 0;
        if(height == null || height.length <= 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < height.length){
            if(stack.isEmpty() || height[i] >= height[stack.peek()]){
                stack.push(i);
                i++;
            }else{
                int p = stack.pop();
                int h = height[p];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                res = Math.max(h*w , res);
            }
        }
        while (!stack.isEmpty()){
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            res = Math.max(h*w, res);
        }
        System.out.println(res);
        return res;
    }

    public static int largestAreaOfRect(int[] height){
        if(height == null || height.length == 0)
            return 0;
        int res = 0;
        //int i = 0;
        for(int i = 0; i < height.length; i++){
            int min = height[i];
            for(int j = i+1; j < height.length; j++){
                if(height[j] < min)
                    min = height[j];
                res = Math.max(res, min*(j-i+1));
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        int[] height = {2,1,5,6,2,3};
        largestRectangle(height);
        largestRect(height);
        largestAreaOfRect(height);
    }
}
