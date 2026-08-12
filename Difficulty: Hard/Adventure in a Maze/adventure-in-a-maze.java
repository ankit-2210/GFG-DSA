class Solution{
    static final int mod=1000000007;
    
    int[] solve(int i, int j, int[][] g, int[][][] dp, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m)
            return new int[]{0, Integer.MIN_VALUE};
            
        if(dp[i][j][0] != -1)
            return new int[]{dp[i][j][0], dp[i][j][1]};
        
        if(i == n-1 && j == m-1){
            dp[i][j][0]=1;
            dp[i][j][1]=g[i][j];
            return new int[]{dp[i][j][0], dp[i][j][1]};
        }
    
            
        int path=0;
        int cost=Integer.MIN_VALUE;    
                    
        if(g[i][j] == 1 || g[i][j] == 3){
            int[] right=solve(i, j+1, g, dp, n, m);
            path=(path+right[0])%mod;
            if(right[0]>0){
                cost=Math.max(cost, g[i][j]+right[1]);
            }
        }
        if(g[i][j] == 2 || g[i][j] == 3){
            int[] down=solve(i+1, j, g, dp, n, m);
            path=(path+down[0])%mod;
            if(down[0]>0){
                cost=Math.max(cost, g[i][j]+down[1]);
            }
        }
        
        dp[i][j][0]=path;
        dp[i][j][1]=cost;
        
        return new int[]{dp[i][j][0], dp[i][j][1]};
    }
    
    public ArrayList<Integer> findWays(int[][] g){
        int n=g.length;
        int m=g[0].length;
        
        int[][][] dp=new int[n][m][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j][0]=-1;
            }
        }
        
        int[] temp=solve(0, 0, g, dp, n, m);
    
        ArrayList<Integer> res=new ArrayList<>();
        res.add(temp[0]);
        if(temp[0] == 0){
            res.add(0);
        }
        else{
            res.add(temp[1]);
        }
        
        return res;
        
    }
}