class Solution{
    long solve(int idx, long prod, int[] arr, int n, boolean flag){
        if(idx>=n){
            if(flag)
                return prod;
            
            return Long.MAX_VALUE;
        }
        
        long take=solve(idx+1, prod*arr[idx], arr, n, true);
        long skip=solve(idx+1, prod, arr, n, flag);
        
        return Math.min(take, skip);
    }
    
    public int minProd(int[] arr){
        int n=arr.length;
        
        return (int)solve(0, 1, arr, n, false);
        
        
    }
}