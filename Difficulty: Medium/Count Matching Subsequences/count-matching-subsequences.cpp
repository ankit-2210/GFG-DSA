#define ll long long int
#define mod 1000000007

class Solution{
    public:
    ll solve(int i, int j, string &s1, string &s2, vector<vector<ll>> &dp, int n, int m){
        if(i>=n && j<m)
            return 0;
            
        if(j == m)
            return 1;
            
        if(dp[i][j] != -1)
            return dp[i][j];
        
        ll take=0;    
        if(s1[i] == s2[j]){
            take=solve(i+1, j+1, s1, s2, dp, n, m);
        }
        ll nottake=solve(i+1, j, s1, s2, dp, n, m);
        
        dp[i][j]=nottake+take;
        return dp[i][j]%mod;
    }
    
    int countWays(string &s1, string &s2){
        int n=s1.size();
        int m=s2.size();
        
        vector<vector<ll>> dp(n+1, vector<ll> (m+1, -1));
        return solve(0, 0, s1, s2, dp, n, m);
        
        
    }
};
