class Solution{
    int minToggle(int[] arr){
        int n=arr.length;
        
        int res=0;
        int ones=0;   
        for(int i=0; i<n; i++){
            if(arr[i] == 1){
                ones++;
            }
            else{
                res=Math.min(res+1, ones);
            }
        }
        
        return res;
        
        
    }
}