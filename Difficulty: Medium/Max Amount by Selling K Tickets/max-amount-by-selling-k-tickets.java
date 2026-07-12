class Solution{
    final static int mod=1000000007;
    public int maxAmount(int[] arr, int k){
        int n=arr.length;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int a: arr){
            pq.add(a);
        }
        
        long res=0;
        while(!pq.isEmpty() && k>0){
            int num=pq.poll();
            
            res=(res+num)%mod;
            num--;
            if(num>0){
                pq.add(num);
            }
            k--;
        
        }
            
        return (int)res;
        
    }
}