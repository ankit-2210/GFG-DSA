class Solution{
    public int formPyramid(int[] arr){
        int n=arr.length;
        
        int[] left=new int[n];
        int[] right=new int[n];
        
        left[0]=Math.min(arr[0], 1);
        right[n-1]=Math.min(arr[n-1], 1);
        
        for(int i=1; i<n; i++){
            left[i]=Math.min(arr[i], left[i-1]+1);
        }
        
        for(int i=n-2; i>=0; i--){
            right[i]=Math.min(arr[i], right[i+1]+1);
        }
        
        int mx=0;
        for(int i=0; i<n; i++){
            mx=Math.max(mx, Math.min(left[i], right[i]));
        }
    
        
        int sum=Arrays.stream(arr).sum();
        return sum-(mx*mx);
        
    }
};