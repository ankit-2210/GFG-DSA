class Solution{
    public void updateArray(int[] arr){
        int n=arr.length;
        
        int prev=1;
        for(int i=0; i<n; i++){
            int curr=arr[i];
            int next=(i == n-1)?1:arr[i+1];
            arr[i]=prev*curr*next;
            prev=curr;
        }
        
        
    }
}