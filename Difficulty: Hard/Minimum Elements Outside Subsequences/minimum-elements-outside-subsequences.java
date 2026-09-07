class Solution{
    int solve(int idx, int inc, int dec, int[] arr, int[][][] dp, int n){
        if(idx>=n)
            return 0;
            
        if(dp[idx][inc+1][dec+1] != -1)
            return dp[idx][inc+1][dec+1];
            
        int len=solve(idx+1, inc, dec, arr, dp, n);
        if(inc == -1 || arr[idx]>arr[inc]){
            len=Math.max(len, 1+solve(idx+1, idx, dec, arr, dp, n));
        }
        if(dec == -1 || arr[idx]<arr[dec]){
            len=Math.max(len, 1+solve(idx+1, inc, idx, arr, dp, n));
        }
        
        dp[idx][inc+1][dec+1]=len;
        return dp[idx][inc+1][dec+1];
    }
    
    
    public int minCount(int[] arr){
        int n=arr.length;
        
        int[][][] dp=new int[n+1][n+1][n+1];
        for(int[][] x: dp){
            for(int[] y: x){
                Arrays.fill(y, -1);
            }
        }
        
        return n-solve(0, -1, -1, arr, dp, n);
        
    }
}