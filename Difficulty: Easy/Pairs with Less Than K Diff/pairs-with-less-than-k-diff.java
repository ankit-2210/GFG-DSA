class Solution{
    public static int countPairs(int arr[], int k){
        int n=arr.length;
        
        int res=0;
        Arrays.sort(arr);
        int i=0, j=1;
        while(j<n){
            while(arr[j]-arr[i]>=k){
                i++;
            }
            
            res += (j-i);
            j++;
        }
        
        return res;
        
        
    }
}
