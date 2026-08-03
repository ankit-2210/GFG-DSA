class Solution{
    public int maxSumWithK(int[] arr, int k){
        int n=arr.length;
        
        int sum=0;
        int i=0;
        while(i<k){
            sum += arr[i];
            i++;
        }
        
        int mx=sum;
        int p=mx;
        
        while(i<n){
            sum += (arr[i]-arr[i-k]);
            p=Math.max(p+arr[i], sum);
            mx=Math.max(mx, p);
            i++;
        }
        
        return mx;
        
        
    }
}