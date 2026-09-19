class Solution{
    int solve(int i, int j, String s1, String s2, int[][] dp, int n, int m){
        if(i>=n || j>=m)
            return 0;
            
        if(dp[i][j] != -1)
            return dp[i][j];
            
        int res=0;
        if(s1.charAt(i) == s2.charAt(j)){
            res=1+solve(i+1, j+1, s1, s2, dp, n, m);
        }
        else{
            res=Math.max(solve(i+1, j, s1, s2, dp, n, m), solve(i, j+1, s1, s2, dp, n, m));
        }
        
        dp[i][j]=res;
        return dp[i][j];
    }       
    
    public int findMinCost(String s1, String s2, int c1, int c2){
        int n=s1.length();
        int m=s2.length();
        
        int[][] dp=new int[n][m];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        
        int lcs=solve(0, 0, s1, s2, dp, n, m);
        return (n-lcs)*c1+(m-lcs)*c2;
        
    }
}