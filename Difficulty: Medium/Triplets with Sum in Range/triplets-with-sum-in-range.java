class Solution{
    int solve(int[] arr, int n, int x){
        
        int res=0;
        for(int i=0; i<n-2; i++){
            int left=i+1;
            int right=n-1;
            
            while(left<right){
                int sum=arr[i]+arr[left]+arr[right];
                if(sum<=x){
                    res += (right-left);
                    left++;
                }
                else{
                    right--;
                }
                
            }
        }
        
        return res;
    }
    
    public int countTriplets(int[] arr, int l, int r) {
        int n=arr.length;
        
        Arrays.sort(arr);
        return solve(arr, n, r)-solve(arr, n, l-1);
        
        
        
    }
}