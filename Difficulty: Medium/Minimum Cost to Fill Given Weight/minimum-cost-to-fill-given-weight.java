class Solution{
    int solve(int idx, int w, int[] c, int[][] dp, int n){
        if(w == 0)
            return 0;
            
        if(idx>=n || w<0)
            return Integer.MAX_VALUE;
            
        if(dp[idx][w] != -1)
            return dp[idx][w];
            
        int nottake=solve(idx+1, w, c, dp, n);
        int take=Integer.MAX_VALUE;
        
        if(c[idx] != -1){
            int next=solve(idx, w-(idx+1), c, dp, n);
            if(next != Integer.MAX_VALUE){
                take=c[idx]+next;
            }
        }
                
        dp[idx][w]=Math.min(take, nottake);
        return dp[idx][w];
    }
    
    public int minimumCost(int[] c, int w){
        int n=c.length;
        
        int sum=Arrays.stream(c).sum();
        int[][] dp=new int[n+1][w+1];
        
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
                
        int res=solve(0, w, c, dp, n);
        if(res == Integer.MAX_VALUE)
            return -1;
        
        return res;
        
    }
}