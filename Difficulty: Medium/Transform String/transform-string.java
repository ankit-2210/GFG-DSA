class Solution{
    int transform(String s1, String s2){
        int n=s1.length();
        int m=s2.length();
        
        if(n != m)
            return -1;
        
        int[] freq=new int[256];
        for(int i=0; i<n; i++){
            char a=s1.charAt(i);
            char b=s2.charAt(i);
            freq[a]++;
            freq[b]--;
        }
        
        for(int i=0; i<freq.length; i++){
            if(freq[i] != 0)
                return -1;
        }
        
        int res=0;
        int i=n-1, j=m-1;
        while(i>=0 && j>=0){
            if(s1.charAt(i) != s2.charAt(j)){
                res++;
                i--;
            }
            else{
                i--;
                j--;
            }
        }
        
        return res;
    
        
    }
}