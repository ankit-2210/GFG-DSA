class Solution{
    public int maxSumSubarray(int[] arr){
        int n=arr.length;
        
        int curr=arr[0];
        int mx=arr[0];
        
        int skip=0;
        for(int i=1; i<n; i++){
            skip=Math.max(curr, skip+arr[i]);
            curr=Math.max(arr[i], curr+arr[i]);
            mx=Math.max(mx, Math.max(skip, curr));
        }
        
        return mx;
        
    }
}