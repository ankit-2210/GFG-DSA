class Solution{
    public ArrayList<Integer> prefSum(int[] arr){
        int n=arr.length;
        
        ArrayList<Integer> res=new ArrayList<>();
        int sum=0;
        int i=0;
        while(i<n){
            sum += arr[i];
            res.add(sum);
            
            i++;
        }
        
        return res;
        
        
    }
}