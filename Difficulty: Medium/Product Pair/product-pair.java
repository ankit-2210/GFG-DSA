class Solution{
    public boolean isProduct(int[] arr, long t){
        int n=arr.length;
        
        HashMap<Long, Integer> mp=new HashMap<>();
        for(int it: arr){
            mp.put((long)it, mp.getOrDefault((long)it, 0)+1);
        }
        
        for(int it: arr){
            if(t%it == 0 && mp.getOrDefault(t/it, 0)>0){
                return true;
            }
        }
    
        return false;
        
    }
};