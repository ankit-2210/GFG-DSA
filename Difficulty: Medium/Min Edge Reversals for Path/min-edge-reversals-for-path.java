class Solution{
    public int minimumEdgeReversal(int[][] e, int n, int src, int dst){
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] it: e){
            int u=it[0];
            int v=it[1];
            
            adj.get(u).add(new int[]{v, 0});
            adj.get(v).add(new int[]{u, 1});
        }
        
        int[] dist=new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[src]=0;
        Deque<Integer> dq=new ArrayDeque<>();
        dq.addFirst(src);
        
        while(!dq.isEmpty()){
            int node=dq.pollFirst();
            
            for(int[] it: adj.get(node)){
                int next=it[0];
                int cost=it[1];
                
                if(dist[node]+cost<dist[next]){
                    dist[next]=dist[node]+cost;
                    if(cost == 0){
                        dq.addFirst(next);
                    }
                    else{
                        dq.addLast(next);
                    }
                }
                
            }
            
        }
        
        if(dist[dst] == Integer.MAX_VALUE)
            return -1;
            
        return dist[dst];
        
        
    }
}