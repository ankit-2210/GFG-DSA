class Solution{
    public int maxProduct(int[] arr, int k){
        int n=arr.length;
        
        Arrays.sort(arr);
        
        int prod=1;
        
        if(arr[n-1] == 0 && (k&1) == 1)
            return 0;
            
        if(arr[n-1]<=0 && (k&1) == 1){
            for(int i=n-1; i>=n-k; i--){
                prod *= arr[i];
            }
            
            return prod;
        }    
            
        int l=0, r=n-1;
        if((k&1) == 1){
            prod *= arr[r];
            r--;
            k--;
        }
        
        k/=2;
        for(int i=0; i<k; i++){
            int leftp=arr[l]*arr[l+1];
            int rightp=arr[r]*arr[r-1];
            
            if(leftp>rightp){
                prod *= leftp;
                l+=2;
            }
            else{
                prod *= rightp;
                r-=2;
            }
        }
        
        return prod;
        
    }
}