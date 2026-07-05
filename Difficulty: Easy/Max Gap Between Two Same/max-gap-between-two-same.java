class Solution{
    public int maxCharGap(String s){
        int n=s.length();
        
        int res=-1;
        Map<Character, Integer> mp=new HashMap<>();
        for(int i=0; i<n; i++){
            if(!mp.containsKey(s.charAt(i))){
                mp.put(s.charAt(i), i);
            }
            else{
                res=Math.max(res, i-mp.get(s.charAt(i))-1);
            }
        }
        
        return res;
        
    }
};