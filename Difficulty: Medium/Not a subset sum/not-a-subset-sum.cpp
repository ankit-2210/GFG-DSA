class Solution{
    public:
    int findSmallest(vector<int> &arr){
        int n=arr.size();
        
        int t=1;
        sort(arr.begin(), arr.end());
        for(int i=0; i<n; i++){
            if(arr[i]>t){
                break;
            }
            t += arr[i];
        }
        
        return t;
        
    }
};