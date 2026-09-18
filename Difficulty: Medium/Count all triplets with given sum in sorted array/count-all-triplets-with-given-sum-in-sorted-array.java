class Solution{
    public int countTriplets(int[] arr, int t){
        int n=arr.length;
        
        int res=0;
        for(int i=0; i<n-2; i++){
            int low=i+1, high=n-1;
            while(low<high){
                int sum=arr[i]+arr[low]+arr[high];
                
                if(sum == t){
                    int val1=arr[low];
                    int val2=arr[high];
                    int c1=0, c2=0;
                    while(low<=high && arr[low] == val1){
                        low++;
                        c1++;
                    }
                    while(low<=high && arr[high] == val2){
                        high--;
                        c2++;
                    }
                    if(val1 == val2){
                        res += (c1*(c1-1)/2);
                    }
                    else{
                        res += (c1*c2);
                    }
                }
                else if(sum>t){
                    high--;
                }
                else{
                    low++;
                }
                
            }
        }
        
        return res;
        
        
        
    }
}