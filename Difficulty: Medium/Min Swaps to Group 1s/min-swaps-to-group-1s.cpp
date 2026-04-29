class Solution{
    public:
    int minSwaps(vector<int> &arr){
        int n=arr.size();
        
        int k=0;
        for(int i=0; i<n; i++){
            if(arr[i] == 1){
                k++;
            }
        }
        
        if(k == 0)
            return -1;
            
        int mn=INT_MAX;
        int curr=0;
        int i=0, j=0;
        while(j<n){
            if(arr[j] == 1){
                curr++;
            }
            
            if(j-i+1 == k){
                mn=min(mn, k-curr);
                if(arr[i] == 1){
                    curr--;
                }
                i++;
            }
            
            j++;
        }
        
        return mn;
        
        
    }
};