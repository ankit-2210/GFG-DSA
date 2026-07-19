class Solution{
    public ArrayList<Boolean> processQueries(int[] arr, int[][] q){
        int n=arr.length;
        
        int[] inc=new int[n];
        int[] dec=new int[n];
        
        inc[n-1]=n-1;
        for(int i=n-2; i>=0; i--){
            if(arr[i]>arr[i+1]){
                inc[i]=i;
            }
            else{
                inc[i]=inc[i+1];
            }
        }
        
        dec[0]=0;
        for(int i=1; i<n; i++){
            if(arr[i]>arr[i-1]){
                dec[i]=i;
            }
            else{
                dec[i]=dec[i-1];
            }
        }
        
        ArrayList<Boolean> res=new ArrayList<>();
        for(int[] it: q){
            int l=it[0];
            int r=it[1];
            if(inc[l]>=dec[r]){
                res.add(true);
            }
            else{
                res.add(false);
            }
        }
        
        return res;
    }
}