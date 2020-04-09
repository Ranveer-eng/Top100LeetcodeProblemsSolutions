
public class containerWithMostWater {

    public static int maxArea(int[] height){
        int n = height.length;
        if(n <= 1)
            return 0;
        int res = 1;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                res = Math.max(res, (j-i)*Math.min(height[i], height[j]));
            }
        }
        System.out.println(res);
        return res;
    }

    public static int maxArUsingSlideWidow(int[] height){
        int n = height.length;
        if(n <= 1)
            return 0;
        int res = 1, max = 0, left = 0, right = n-1;
        while(left < right){
            int min = Math.min(height[left], height[right]);
            max = min*(right - left);
            res = Math.max(max, res);
            if(height[left] == min){
                left++;
            }else
                right--;
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        maxArea(height);                        //Normal Method
        maxArUsingSlideWidow(height);           //Forward and Backward Movement method
    }
}
