class Solution{
    public int countKdivPairs(int[] arr, int k){
        int n=arr.length;
        
        if(n == 1)
            return 0;
        
        HashMap<Integer, Integer> mp=new HashMap<>();
        // mp.put(0, 1);
        
        int res=0;
        for(int i=0; i<n; i++){
            int rem=arr[i]%k;
            int need=(k-rem)%k;
            
            if(mp.containsKey(need))
                res += mp.get(need);

            mp.put(rem, mp.getOrDefault(rem, 0)+1); 
    
        }
        
        return res;
        
        
    }
}