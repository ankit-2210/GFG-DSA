class Solution{
    public int longestSubseq(int[] arr){
        int n=arr.length;
        
        int res=0;
        HashMap<Integer, Integer> mp=new HashMap<>();
        for(int x: arr){
            int t=Math.max(mp.getOrDefault(x-1, 0), mp.getOrDefault(x+1, 0))+1;
            mp.put(x, Math.max(mp.getOrDefault(x, 0), t));
            
            res=Math.max(res, t);
        }
        
        return res;
        
        
    }
}
