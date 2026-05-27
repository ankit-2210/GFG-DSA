class Solution{
    public boolean wifiRange(String s, int x){
        int n=s.length();
        
        int[] v=new int[n+1];
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1'){
                int left=Math.max(i-x, 0);
                int right=Math.min(i+x+1, n);
                
                v[left]+=1;
                v[right]-=1;
            }
        }
        
        int sum=0;
        for(int i=0; i<n; i++){
            sum += v[i];
            if(sum<=0)
                return false;
        }
        
        return true;
        
        
        
    }
}