class Solution{
    public:
    int solve(int idx, int sum, vector<int> &arr, int pick, int k, vector<vector<int>> &dp, int n){
        if(sum%k == 0 && pick>0)
            return true;
        
        if(idx>=n)
            return false;
        
        if(dp[idx][sum] != -1)
            return dp[idx][sum];
            
        int nottake=solve(idx+1, sum, arr, pick, k, dp, n);
        int take=solve(idx+1, (sum+arr[idx])%k, arr, pick+1, k, dp, n);
        
        dp[idx][sum]=take||nottake;
        return dp[idx][sum];
    }
    
    bool divisibleByK(vector<int> &arr, int k){
        int n=arr.size();
        
        int sum=accumulate(arr.begin(), arr.end(), 0);
        vector<vector<int>> dp(n+1, vector<int> (k+1, -1));
        
        return solve(0, 0, arr, 0, k, dp, n);
        
    }
};