class Solution{
    int solve(int idx, int prev, int[] h, int[] l, int[][] dp, int n){
        if(idx>=n)
            return 0;
            
            
        if(dp[idx][prev] != -1)
            return dp[idx][prev];
            
        int lowtake=0, hightake=0, nottake=0;
        nottake=solve(idx+1, 0, h, l, dp, n);
        lowtake=l[idx]+solve(idx+1, 1, h, l, dp, n);
        if(idx == 0 || prev == 0){
            hightake=h[idx]+solve(idx+1, 2, h, l, dp, n);
        }
        
        dp[idx][prev]=Math.max(nottake, Math.max(lowtake, hightake));
        return dp[idx][prev];
        
    }
    
    public int maxTask(int[] h, int[] l){
        int n=h.length;
        
        int[][] dp=new int[n+1][4];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        
        
        return solve(0, 0, h, l, dp, n);
        
        
    }
}