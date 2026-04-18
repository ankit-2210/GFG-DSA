class Solution{
    public:
    int maxOnes(vector<int> &arr){
        int n=arr.size();
        
        int zeros=0;
        int ones=0;
        int curr=0;
        for(int i=0; i<n; i++){
            if(arr[i] == 1){
                ones++;
            }
            int v=arr[i]==0?1:-1;
            curr=max(v, curr+v);
            zeros=max(zeros, curr);
        }
        
        return ones+zeros;
        
    }
};