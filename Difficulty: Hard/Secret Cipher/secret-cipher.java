class Solution{
    void solve(String s, int[] lps){
        int n=s.length();
        
        if(n == 0)
            return;
        
        lps[0]=0;
        for(int i=1; i<n; i++){
            int len=lps[i-1];
            
            while(len>0 && s.charAt(i) != s.charAt(len)){
                len=lps[len-1];
            }
            
            if(s.charAt(i) == s.charAt(len)){
                len++;
            }
            
            lps[i]=len;
        }
    }
    
    String solve1(String s){
        int n=s.length();
        
        if(n == 0)
            return "";
        
        int[] lps=new int[n];
        solve(s, lps);
        
        Stack<Character> st=new Stack<>();
        for(int i=n-1; i>0; i--){
            int len=i+1;
            
            if(len%2 == 1){
                st.push(s.charAt(i));
                continue;
            }
            
            int lp=lps[i];
            int bl=len-lp;
            
            boolean flag=false;
            if(lp*2>=len && len%bl == 0 && (len/bl)%2 == 0){
                flag=true;
            }
            
            
            if(flag){
                st.push('*');
                i=len/2;
            }
            else{
                st.push(s.charAt(i));
            }
        }
        
        StringBuilder str=new StringBuilder();
        str.append(s.charAt(0));
        
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        
        return str.toString();
    }
    
    
    
    public String compress(String s){
        int n=s.length();
        
        return solve1(s);
        
        
        
    }
}
