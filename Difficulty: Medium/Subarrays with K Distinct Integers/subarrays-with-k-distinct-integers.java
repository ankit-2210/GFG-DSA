class Solution{
    int solve(int[] arr, int k, int n){
        Map<Integer, Integer> mp=new HashMap<>();
        int res=0;
        int i=0, j=0;
        while(j<n){
            mp.put(arr[j], mp.getOrDefault(arr[j], 0)+1);
            while(mp.size()>k){
                mp.put(arr[i], mp.getOrDefault(arr[i], 0)-1);
                if(mp.get(arr[i]) == 0){
                    mp.remove(arr[i]);
                }
                i++;
            }
            
            res += (j-i+1);
            j++;
        }
        
        return res;
    }
    
    public int exactlyK(int arr[], int k){
        int n=arr.length;
        
        return solve(arr, k, n)-solve(arr, k-1, n);
    
    }
}
