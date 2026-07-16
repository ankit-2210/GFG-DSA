class Solution{
    int find(int x, int[] parent){
        if(parent[x] == x)
            return x;
        return parent[x]=find(parent[x], parent);
    }
    
    void solve(int x, int y, int[] parent, int[] rank){
        int x1=find(x, parent);
        int y1=find(y, parent);
        
        if(x1 == y1)
            return;
        
        if(rank[x1]<rank[y1]){
            parent[x1]=y1;
            rank[y1]++;
        }
        else{
            parent[y1]=x1;
            rank[x1]++;
        }
    }
    
    
    public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj){
        
        int[] parent=new int[V];
        int[] rank=new int[V];
        for(int i=0; i<V; i++){
            parent[i]=i;
        }
        
        for(int u=0; u<V; u++){
            for(int v: adj.get(u)){
                if(u<v){
                    int u1=find(u, parent);
                    int v1=find(v, parent);
                    if(u1 == v1)
                        return true;
                        
                    solve(u, v, parent, rank);
                }
            }
        }
        
        return false;
        
        
    }
}