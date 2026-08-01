class Solution{
    public:
    int findMax(int n, vector<int> &a, vector<int> &b, vector<int> &k){
        int m=a.size();
        
        map<int, int> mp;
        for(int i=0; i<m; i++){
            mp[a[i]] += k[i];
            mp[b[i]+1] -= k[i];
        }
        
        int sum=0;
        int res=0;
        for(auto it: mp){
            sum += it.second;
            res=max(res, sum);
        }
        
        return res;
        
    }
};