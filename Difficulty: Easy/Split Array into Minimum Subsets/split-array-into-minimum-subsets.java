class Solution{
    int minSubsets(int arr[]){
        int n=arr.length;
        
        int res=0;
        Arrays.sort(arr);
        for(int i=0; i<n-1; i++){
            if(arr[i]+1 != arr[i+1]){
                res++;
            }
        }
        
        return res+1;
        
    }
}