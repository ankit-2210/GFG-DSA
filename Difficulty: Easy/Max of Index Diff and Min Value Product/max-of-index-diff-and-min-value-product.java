class Solution{
    public int maxValue(ArrayList<Integer> arr){
        int n=arr.size();
        
        int res=0;
        int i=0, j=n-1;
        while(i<j){
           res=Math.max(res, (j-i)*Math.min(arr.get(i), arr.get(j)));
           if(arr.get(i)<arr.get(j)){
               i++;
           }
           else{
               j--;
           }
       }
        
        return res;
        
    }
}