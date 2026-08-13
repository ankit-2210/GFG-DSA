class Solution {
    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges){
        
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        int[] indegree=new int[V];
        for(ArrayList<Integer> e: edges){
            int u=e.get(0);
            int v=e.get(1);
            int wt=e.get(2);
            
            adj.get(u).add(new int[]{v, wt});
            indegree[v]++;
        }
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                pq.offer(i);
            }
        }
        
        int[] dist=new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src]=0;
        
        while(!pq.isEmpty()){
            int node=pq.poll();
            
            for(int[] it: adj.get(node)){
                int nxt=it[0];
                int wt=it[1];
                
                if(dist[node] != Integer.MIN_VALUE){
                    dist[nxt]=Math.max(dist[nxt], dist[node]+wt);
                }
                
                indegree[nxt]--;
                if(indegree[nxt] == 0){
                    pq.offer(nxt);
                }
            }
            
        }
        
        return dist;
        
        
        
    }
}
