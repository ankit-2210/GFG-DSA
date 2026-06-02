class Solution{
    public int sumDiffPairs(int[] arr, int k){
        int n=arr.length;
        
        Arrays.sort(arr);
        int res=0;
        int i=n-1;
        while(i>0){
            if(arr[i]-arr[i-1]<k){
                res += (arr[i]+arr[i-1]);
                i-=2;
            }
            else{
                i-=1;
            }
        }
        
        return res;
        
        
    }
}