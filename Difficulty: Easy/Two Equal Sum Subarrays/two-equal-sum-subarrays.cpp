class Solution{
    public:
    bool canSplit(vector<int> &arr){
        int n=arr.size();
        
        int sum=accumulate(arr.begin(), arr.end(), 0);
        if(sum%2 != 0)
            return false;
            
        sum /= 2;
        for(int i=0; i<n; i++){
            sum -= arr[i];
            if(sum == 0)
                return true;
            if(sum<0)
                return false;
        }
        
        return false;
        
    }
};
