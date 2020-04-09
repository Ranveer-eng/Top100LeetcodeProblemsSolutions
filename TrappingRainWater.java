public class TrappingRainWater {
    public static int trap(int[] height){
        int area = 0;
        if(height == null || height.length <= 2)
            return area;
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int max = height[0];
        left[0] = height[0];
        for(int i = 1; i < height.length; i++){
            if(height[i] < max)
                left[i] = max;
            else{
                left[i] = height[i];
                max = height[i];
            }
        }
        max = height[height.length - 1];
        right[height.length  - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--){
            if(height[i] < max)
                right[i] = max;
            else {
                right[i] = height[i];
                max = height[i];
            }
        }
        for(int i = 0; i < height.length; i++){
            area += Math.min(left[i], right[i]) - height[i];
        }
        System.out.println(area);
        return area;
    }

    public static int trapWater(int[] height){
        int n = height.length, area = 0;
        if(n <= 1)
            return 0;
        for(int i = 0; i < n-1; i++){
            int cur = height[i], j = 0;
            for(j = i+1; j < n; j++){
                if(height[j] >= cur)
                    break;
            }
            if(j != n){
                for(int k = i; k <= j; k++){
                    area += (cur - Math.min(cur, height[k]));
                }
                i = j - 1;
            }else{
                //area += height[i+1];
            }
        }
        System.out.println(area);
        return area;
    }

    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] heights = {2,1,0,7,8,6,5};
        trap(heights);
        trapWater(heights);
    }
}
