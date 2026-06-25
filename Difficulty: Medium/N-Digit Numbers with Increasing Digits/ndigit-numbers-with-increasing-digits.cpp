class Solution{
    public:
    void solve(int idx, int num, vector<int> &res, int n){
        if(idx>=n){
            res.push_back(num);
            return;
        }
        
        int rem=num%10;
        for(int i=rem+1; i<=9; i++){
            solve(idx+1, num*10+i, res, n);
        }
        
    }
    
    vector<int> increasingNumbers(int n){
        
        vector<int> res;
        if(n == 1)
            res.push_back(0);
            
        solve(0, 0, res, n);
        return res;
        
    }
};