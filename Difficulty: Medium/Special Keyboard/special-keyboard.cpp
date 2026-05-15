class Solution{
    public:
    int optimalKeys(int n){
    
        vector<int> dp(n+1);
        for(int i=1; i<=n; i++){
            dp[i]=i;
        }
        
        for(int i=2; i<=n; i++){
            for(int j=0; j<i-2; j++){
                dp[i]=max(dp[i], dp[j]*(i-j-2+1));
            }
        }
        
        return dp[n];
        
    }
};