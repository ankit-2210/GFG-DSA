class Solution{
    public int minCost(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;
        
        int[][] dp=new int[n][3];
        dp[0][0]=mat[0][0];
        dp[0][1]=mat[0][1];
        dp[0][2]=mat[0][2];
        
        for(int i=1; i<n; i++){
            dp[i][0]=mat[i][0]+Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1]=mat[i][1]+Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2]=mat[i][2]+Math.min(dp[i-1][0], dp[i-1][1]);
        }
        
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
        
    }
}