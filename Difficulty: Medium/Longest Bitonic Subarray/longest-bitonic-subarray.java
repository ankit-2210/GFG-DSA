class Solution{
    public int bitonic(int[] arr){
        int n=arr.length;
        
        int[] inc=new int[n];
        Arrays.fill(inc, 1);
        
        int[] dec=new int[n];
        Arrays.fill(dec, 1);
        
        
        for(int i=1; i<n; i++){
            if(arr[i]>=arr[i-1]){
                inc[i]=1+inc[i-1];
            }
        }
        
        for(int i=n-2; i>=0; i--){
            if(arr[i]>=arr[i+1]){
                dec[i]=1+dec[i+1];
            }
        }
        
        int res=0;
        for(int i=0; i<n; i++){
            res=Math.max(res, inc[i]+dec[i]-1);
        }
        
        return res;
    
        
    }
}