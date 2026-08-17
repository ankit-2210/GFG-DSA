class Solution{
    public int minThrows(int n, int[] lad, int[] sn){
        
        HashMap<Integer, Integer> mp=new HashMap<>();
        for(int i=0; i<lad.length; i+=2){
             mp.put(lad[i], lad[i+1]);
        }
        
        for(int i=0; i<sn.length; i+=2){
             mp.put(sn[i], sn[i+1]);
        }
        
        int last=n*n;
        boolean[] visited=new boolean[last+1];
        Arrays.fill(visited, false);
        
        Queue<Integer> q=new LinkedList<>();
        
        q.offer(1);
        visited[1]=true;
        
        int res=0;
        while(!q.isEmpty()){
            int size=q.size();
            
            while(size-->0){
                int num=q.poll();
            
                if(num == last)
                    return res;
            
                for(int i=1; i<=6; i++){
                    int next=num+i;
                    
                    if(next>last)
                        continue;
                
                    if(mp.containsKey(next)){
                        next=mp.get(next);
                    }
                
                    if(visited[next] == false){
                        q.offer(next);
                        visited[next]=true;
                    }
                }
            }
            
            res++;
        }
        
        return -1;
        
    }
}