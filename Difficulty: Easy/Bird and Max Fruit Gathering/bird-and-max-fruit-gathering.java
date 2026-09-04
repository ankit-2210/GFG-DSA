class Solution{
    public int maxFruits(ArrayList<Integer> arr, int m){
        int n=arr.size();
        
        int res=Integer.MIN_VALUE;
        int sum=0;
        int i=0, j=0;
        while(j<n+m-1){
            sum += arr.get(j%n);
            
            if(j-i+1 == m){
                // System.out.println(sum + " ");
                res=Math.max(res, sum);
                sum -= arr.get(i);
                i++;
            }
            
            j++;
        }
        
        return res;
        
        
    }
}