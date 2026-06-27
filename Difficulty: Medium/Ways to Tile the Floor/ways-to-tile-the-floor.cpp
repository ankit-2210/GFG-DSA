#define ll long long int
#define mod 1000000007

class Solution{
    public:
    int solve(int idx, int n, int m, vector<ll> &dp){
        if(idx<m)
            return dp[idx]=1;
        if(idx == m)
            return dp[idx]=2;
            
        if(dp[idx] != -1)
            return dp[idx];
            
        dp[idx]=(solve(idx-1, n, m, dp)+solve(idx-m, n, m, dp))%mod;
        return dp[idx];
    }
    
    int countWays(int n, int m){
        vector<ll> dp(n+1, -1);
        dp[0]=0;
        return solve(n, n, m, dp);
    
    }
};