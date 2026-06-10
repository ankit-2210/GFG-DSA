class Solution{
    public:
    bool solve(int t, vector<int> &arr, int n){
        
        int low=0, high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid] == t){
                return true;
            }
            else if(arr[mid]>t){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        
        return false;
    }
    
    int binarySearchable(vector<int> &arr){
        int n=arr.size();
        
        int res=0;
        for(int i=0; i<n; i++){
            if(solve(arr[i], arr, n)){
                res++;
            }
        }
        
        return res;
    }
};