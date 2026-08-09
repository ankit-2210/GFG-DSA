class Solution{
    int solve(int i, int j, int[][] mat, int[][] dp, int n, int m){
        if(i>=n)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
            
        int temp=0;
        for(int k=0; k<m; k++){
            if(k != j){
                temp=Math.max(temp, mat[i][j]+solve(i+1, k, mat, dp, n, m));
            }
        }
        
        dp[i][j]=temp;
        return dp[i][j];
        
    }
    
    public int zigzagSequence(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;
        
        if(n == 1 && m == 1)
            return mat[0][0];
        
        
        int[][] dp=new int[n][m];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        
        int res=0;
        for(int j=0; j<m; j++){
            res=Math.max(res, solve(0, j, mat, dp, n, m));    
        }
        
        return res;
        
        
    }
}