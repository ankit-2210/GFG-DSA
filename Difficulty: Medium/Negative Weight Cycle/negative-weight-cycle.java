class Solution{
    public boolean isNegativeWeightCycle(int V, int[][] e){
        int[] dist=new int[V];
        
        for(int i=0; i<V-1; i++){
            boolean flag=false;
            
            for(int[] it: e){
                int u=it[0];
                int v=it[1];
                int w=it[2];
                
                if(dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                    flag=true;
                }
            }
            
            if(flag == false)
                return false;
        }
        
        for(int[] it: e){
            int u=it[0];
            int v=it[1];
            int w=it[2];
            
            if(dist[u]+w<dist[v])
                return true;
        }
        
        return false;
        
    }
}