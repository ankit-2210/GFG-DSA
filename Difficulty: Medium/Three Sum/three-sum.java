class Solution{
    public static ArrayList<ArrayList<Integer>> triplets(int[] arr){
        int n=arr.length;
        
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0; i<n-2; i++){
            if(i>0 && arr[i] == arr[i-1]){
                continue;
            }
            
            int low=i+1, high=n-1;
            while(low<high){
                int sum=arr[i]+arr[low]+arr[high];
                
                if(sum == 0){
                    ArrayList<Integer> t=new ArrayList<>();
                    t.add(arr[i]);
                    t.add(arr[low]);
                    t.add(arr[high]);
                    res.add(t);
                    
                    while(low<high && arr[low] == arr[low+1]){
                        low++;
                    }
                    while(low<high && arr[high] == arr[high-1]){
                        high--;
                    }
                    
                    low++;
                    high--;
                }
                else if(sum>0){
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
