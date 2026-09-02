class Solution{
    public int solve(int n, String s){
        int m=s.length();
        
        Set<Character> st = new HashSet<>();
        Set<Character> rt = new HashSet<>();
        int res=0;
        
        for(char ch: s.toCharArray()){
            if(rt.contains(ch)){
                rt.remove(ch);
            }
            else if(st.contains(ch)){
                st.remove(ch);
            }
            else if(st.size()<n){
                st.add(ch);
            }
            else{
                res++;
                rt.add(ch);
            }
            
        }
        
        return res;
        
        
    }
}
