class Solution{
    public int maxDiffSubArrays(int[] arr){
        int n=arr.length;
        
        int[] leftmx=new int[n];
        int[] rightmx=new int[n];
        
        int[] leftmn=new int[n];
        int[] rightmn=new int[n];
        
        leftmx[0]=arr[0];
        leftmn[0]=arr[0];
        
        int curr1=arr[0];
        int curr2=arr[0];
        
        for(int i=1; i<n; i++){
            curr1=Math.max(arr[i], curr1+arr[i]);
            leftmx[i]=Math.max(leftmx[i-1], curr1);
            
            curr2=Math.min(arr[i], curr2+arr[i]);
            leftmn[i]=Math.min(leftmn[i-1], curr2);
        }
        
        
        rightmx[n-1]=arr[n-1];
        rightmn[n-1]=arr[n-1];
        
        curr1=arr[n-1];
        curr2=arr[n-1];
        
        for(int i=n-2; i>=0; i--){
            curr1=Math.max(arr[i], curr1+arr[i]);
            rightmx[i]=Math.max(rightmx[i+1], curr1);
            
            curr2=Math.min(arr[i], curr2+arr[i]);
            rightmn[i]=Math.min(rightmn[i+1], curr2);
        }
        
        int res=0;
        for(int i=0; i<n-1; i++){
            res=Math.max(res, Math.abs(leftmn[i]-rightmx[i+1]));
            res=Math.max(res, Math.abs(leftmx[i]-rightmn[i+1]));
        }
        
        return res;
        
        
        
        
    }
}