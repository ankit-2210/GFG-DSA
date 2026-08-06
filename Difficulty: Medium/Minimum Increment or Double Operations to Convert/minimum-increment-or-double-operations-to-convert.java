class Solution{
    public int countMinOperations(int arr[]){
        int n=arr.length;
        
        int res=0;
        int zero=0;
        while(zero != n){
            zero=0;
            for(int i=0; i<n; i++){
                if(arr[i]%2 != 0){
                    res += 1;
                    arr[i] -= 1;
                }
                
                if(arr[i] == 0){
                    zero += 1;
                }
            }
            
            for(int i=0; i<n; i++){
                arr[i] /= 2;
            }
            
            
            if(zero == n)
                break;
            
            res++;
        }
        
        return res;
        
    }
}