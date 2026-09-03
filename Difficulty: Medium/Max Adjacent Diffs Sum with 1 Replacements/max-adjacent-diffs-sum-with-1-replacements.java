class Solution{
    public int maxDiffSum(int[] arr){
        int n=arr.length;
        
        int keep=0, change=0;
        for(int i=1; i<n; i++){
            int newKeep=Math.max(keep+Math.abs(arr[i]-arr[i-1]), change+Math.abs(arr[i]-1));
            int newChange=Math.max(keep+Math.abs(arr[i-1]-1), change+Math.abs(1-1));
            
            keep=newKeep;
            change=newChange;
        }
        
        // System.out.println(keep + " " + change);
        return Math.max(keep, change);
        
        
    }
}