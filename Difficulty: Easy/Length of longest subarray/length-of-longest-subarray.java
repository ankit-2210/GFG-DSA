class Solution{
    public int longestSubarray(int arr[]){
        int n=arr.length;
        
        int res=0;
        int len=0;
        for(int i=0; i<n; i++){
            if(arr[i]>=0){
                len += 1;
            }   
            else{
                len=0;
            }
            
            res=Math.max(res, len);
        }
        
        return res;
        
        
    }
}