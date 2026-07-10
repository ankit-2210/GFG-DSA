class Solution{
    public int getCount(int n){
        
        int res=0;
        for(int k=2; k*(k+1)/2<=n; k++){
            int num=n-(k*(k-1)/2);
            if(num>0 && num%k == 0){
                res++;
            }
        }
        
        return res;
    }
};