class Solution{
    int solve(int num, int[] arr, int n){
        int low=n/2, high=n-1;
        int idx=-1;
        while(low<=high){
            int mid=(low+high)/2;
            
            if(5*arr[mid]<=num){
                idx=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        
        return idx;
        
    }
    
    public int dominantPairs(int[] arr){
        int n=arr.length;
        
        int res=0;
        Arrays.sort(arr, n/2, n);
        for(int i=0; i<n/2; i++){
            int idx=solve(arr[i], arr, n);
            if(idx != -1){
                res += (idx-n/2)+1;
            }
        }
        
        return res;
        
    }
}