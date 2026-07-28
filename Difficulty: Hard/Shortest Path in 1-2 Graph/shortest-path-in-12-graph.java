class Solution {
    static class Pair{
        int node, dist;
        Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }   
    
    public int shortestPath(int V, int s, int d, int[][] e){
        
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] it: e){
            int u=it[0];
            int v=it[1];
            int w=it[2];
            
            
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        
        int[] dist=new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b)->a.dist-b.dist);
        
        dist[s]=0;
        pq.offer(new Pair(s, 0));
        
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            
            int node=curr.node;
            int dt=curr.dist;
            
            if(dt>dist[node])
                continue;
                
            for(Pair it: adj.get(node)){
                if(dist[node]+it.dist<dist[it.node]){
                    dist[it.node]=dist[node]+it.dist;
                    pq.offer(new Pair(it.node, dist[it.node]));
                }
            }
            
        }
        
        if(dist[d] == Integer.MAX_VALUE)
            return -1;
        
        return dist[d];
        
    }
}