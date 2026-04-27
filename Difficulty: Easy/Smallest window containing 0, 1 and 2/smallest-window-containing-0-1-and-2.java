class Solution{
    public int smallestSubstring(String s){
        int n=s.length();
        
        int res=Integer.MAX_VALUE;
        int i=0, j=0;
        HashMap<Character, Integer> mp=new HashMap<>();
        while(j<n){
            char ch=s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
            while(mp.size() == 3){
                res=Math.min(res, j-i+1);
                char lch=s.charAt(i);
                mp.put(lch, mp.get(lch)-1);
                if(mp.get(lch) == 0){
                    mp.remove(lch);
                }
                
                i++;
            }
            
            j++;
        }
        
        if(res == Integer.MAX_VALUE)
            return -1;
        
        return res;
        
    }
};
