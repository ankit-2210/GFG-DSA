class Solution{
    public int countSubstring(String s){
        int n=s.length();
        
        HashMap<Integer, Integer> mp=new HashMap<>();
        mp.put(0, 1);
        int sum=0;
        int curr=0;
        int res=0;
        
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '0'){
                sum -= 1;
            }
            else{
                sum += 1;
            }
            
            if(s.charAt(i) == '0'){
                curr -= mp.getOrDefault(sum, 0);    
            }
            else{
                curr += mp.getOrDefault(sum-1, 0);
            }
            
            res += curr;
            mp.put(sum, mp.getOrDefault(sum, 0)+1);
        }
        
        return res;
        
        
    }
}