class Solution{
    public:
    vector<int> findMean(vector<int> &arr, vector<vector<int>> &q){
        int n=arr.size();
        
        vector<int> prefix(n);
        prefix[0]=arr[0];
        for(int i=1; i<n; i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        
        vector<int> res;
        for(auto it: q){
            int l=it[0];
            int r=it[1];
            int sum=prefix[r]-(l-1>=0?prefix[l-1]:0);
            int mean=sum/(r-l+1);
            res.push_back(mean);
        }
        
        return res;
        
        
        
    }
};