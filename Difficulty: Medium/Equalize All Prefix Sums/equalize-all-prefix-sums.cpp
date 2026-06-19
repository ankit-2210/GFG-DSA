class Solution{
    public:
    vector<int> optimalArray(vector<int> &arr){
        int n=arr.size();
        
        vector<int> res(n);
        res[0]=0;
        for(int i=1; i<n; i++){
            res[i]=res[i-1]+(arr[i]-arr[i/2]);
        }
        
        return res;
        
    }
};