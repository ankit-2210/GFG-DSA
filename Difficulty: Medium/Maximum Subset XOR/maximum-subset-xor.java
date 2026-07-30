class Solution{
    public int maxSubsetXOR(int[] arr){
        int n=arr.length;
        
        if(n == 0)
            return 0;
            
        int num=0;
        while(true){
            int mx=Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                mx=Math.max(mx, arr[i]);
            }
            
            if(mx == 0)
                return num;
            
            num=Math.max(num, num^mx);
            for(int i=0; i<n; i++){
                arr[i]=Math.min(arr[i], arr[i]^mx);
            }
            
        }
        
        
        
        
    }
}