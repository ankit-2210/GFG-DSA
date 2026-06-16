class Solution{
    public:
    vector<int> constructList(vector<vector<int>> &q){
        int n=q.size();
        
        int x=0;
        vector<int> res;
        for(int i=n-1; i>=0; i--){
            int a=q[i][0];
            int b=q[i][1];
            if(a == 0){
                b ^= x;
                res.push_back(b);
            }
            else{
                x ^= b;
            }
        }
        
        res.push_back(x);
        sort(res.begin(), res.end());
            
        return res;
    }
};
