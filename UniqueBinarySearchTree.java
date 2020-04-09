public class UniqueBinarySearchTree {
    public static int totalBST(int n){
        int res = 0;
        res = allUniqueTrees(n, 0, 0, n);
        System.out.println(res);
        return res;
    }
    private static int allUniqueTrees(int n, int left, int right, int current){
        if((left + right) == n || left == n || right == n  || current == 1){
            return 1;
        }else if(left > n || right > n || current > n || n <= 1)
            return 0;
        else{
            return allUniqueTrees(n, left + 1, right, current-1) + allUniqueTrees(n, left, right + 1, current - 1); //+ allUniqueTrees(n, left, right, current-1);
        }
    }

    public static int uniqueTree(int n){
        if(n <= 1)
            return n;
        int res = (n-1)*(n-1) + 1;
        System.out.println(res);
        return res;
    }

    public static int allUniqueTrees(int n){
        int[] cnt = new int[n+1];
        cnt[0] = 1;
        cnt[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= i-1; j++){
                cnt[i] = cnt[i] + cnt[j]*cnt[i-j-1];
            }
        }
        System.out.println(cnt[n]);
        return cnt[n];
    }

    public static int totalNumOfTrees(int n){
        if(n <= 1)
            return n;
        int res = getAllTrees(1, n);
        System.out.println(res);
        return res;
    }
    private static int getAllTrees(int i, int n){
        if(i >= n)
            return 1;
        int ans = 0;
        for(int j = i; j <= n; j++){
            ans += getAllTrees(i, j-1)*getAllTrees(j+1, n);
        }
        return ans;
    }

    public static void main(String[] args){
        //totalBST(3);
        uniqueTree(3);
        allUniqueTrees(4);
        totalNumOfTrees(4);
    }
}
