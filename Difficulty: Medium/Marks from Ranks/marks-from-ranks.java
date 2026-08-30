class Solution{
    int solve(int val, int[] prefix, int n){
        int low=0, high=n-1;
        
        while(low<high){
            int mid=low+(high-low)/2;
            
            if(prefix[mid]<val){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        
        return low;
        
    }
    
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank){
        int n=l.length;
        
        int[] prefix=new int[n];
        prefix[0]=r[0]-l[0]+1;
        for(int i=1; i<n; i++){
            prefix[i]=prefix[i-1]+(r[i]-l[i]+1);
        }
        
        ArrayList<Integer> res=new ArrayList<>();
        for(int rk: rank){
            int idx=solve(rk, prefix, n);
            int prev = (idx>0 ? prefix[idx-1] : 0);
            
            res.add(l[idx]+(rk-prev-1));
        }
        
        return res;
        
        
    }
}