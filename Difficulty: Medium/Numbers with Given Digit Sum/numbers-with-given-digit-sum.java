class Solution{
    static final int mod=1000000007;
    
    int solve(int idx, int total, int n, int sum, int[][] dp){
        if(idx == n){
            if(total == sum)
                return 1;
            return 0;
        }
        
        if(total>sum)
            return 0;
        
        if(dp[idx][total] != -1)
            return dp[idx][total];
        
        int temp=0;
        int start=(idx == 0)?1:0;
        for(int d=start; d<=9; d++){
            if(total+d<=sum){
                temp=(temp+solve(idx+1, total+d, n, sum, dp))%mod;
            }
        }
        
        dp[idx][total]=temp;
        return dp[idx][total];
    }
    
    public int countWays(int n, int sum){
        if(sum<1 || sum>9*n)
            return -1;
        
        int[][] dp=new int[n+1][sum+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        
        int res=solve(0, 0, n, sum, dp);
        if(res == 0)
            return -1;
            
        return res;
        
    }
};