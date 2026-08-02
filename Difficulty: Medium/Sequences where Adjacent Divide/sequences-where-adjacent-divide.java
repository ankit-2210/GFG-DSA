class Solution{
    int solve(int idx, int prev, int[][] dp, int n, int m){
        if(idx >= n)
            return 1;
        
        if(dp[idx][prev] != -1)
            return dp[idx][prev];
            
            
        int count=0;
        for(int i=1; i<=m; i++){
            if(prev%i == 0 || i%prev == 0){
                count += solve(idx+1, i, dp, n, m);
            }
        }
        
        dp[idx][prev]=count;
        return dp[idx][prev];
    }
    
    public int count(int n, int m){
        
        int[][] dp=new int[n+1][m+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        
        return solve(0, 1, dp, n, m);
        
    }
}