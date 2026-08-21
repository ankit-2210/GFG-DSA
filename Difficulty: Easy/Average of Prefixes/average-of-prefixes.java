class Solution{
    public int[] prefixAvg(int[] arr){
        int n=arr.length;
        
        int[] res=new int[n];
        int sum=0;
        int i=0;
        
        while(i<n){
            sum += arr[i];
            res[i]=(sum/(i+1));
            
            i++;
        }
        
        return res;
        
        
    }
}