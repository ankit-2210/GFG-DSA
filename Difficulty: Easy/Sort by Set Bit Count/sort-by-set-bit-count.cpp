class Solution{
    public:
    int solve(int n){
        int c=0;
        while(n>0){
            if(n&1)
                c++;
            n>>=1;
        }
        return c;
    }
    
    vector<int> sortBySetBitCount(vector<int> &arr){
        int n=arr.size();
        
        vector<pair<int, int>> v;
        for(int i=0; i<n; i++){
            int bit=solve(arr[i]);
            v.push_back({bit, arr[i]});
        }
        
        stable_sort(v.begin(), v.end(), [](auto &a, auto &b){
            return a.first>b.first;
        });
        
        vector<int> res;
        for(auto it: v){
            res.push_back(it.second);
        }
            
        return res;
    }
};