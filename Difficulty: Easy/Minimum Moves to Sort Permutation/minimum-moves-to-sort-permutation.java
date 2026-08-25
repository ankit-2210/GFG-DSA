class Solution{
    public int minMoves(int[] arr){
        int n=arr.length;
        
        int res=Integer.MIN_VALUE;
        HashMap<Integer, Integer> mp=new HashMap<>();
        for(int i=0; i<n; i++){
            if(mp.containsKey(arr[i]-1)){
                mp.put(arr[i], mp.get(arr[i]-1)+1);
            }
            else{
                mp.put(arr[i], 1);
            }
            
            res=Math.max(res, mp.get(arr[i]));
        }
        
        return n-res;
    }
}