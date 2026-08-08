class Solution{
    int find(int node, int[] parent){
        if(parent[node] == node)
            return node;
        return parent[node]=find(parent[node], parent);
    }
    
    boolean solve(int a, int b, int[] parent, int[] rank){
        int a1 = find(a, parent);
        int b1 = find(b, parent);
        
        if(a1 == b1)
            return false;
            
        if(rank[a1]<rank[b1]){
            parent[a1]=b1;
        }
        else if(rank[a1]>rank[b1]){
            parent[b1]=a1;
        }
        else{
            parent[b1]=a1;
            rank[a1]++;
        }
        
        return true;
    }
    
    
    int minEdgesReq(int n, int[][] edges){
        
        int[] parent=new int[n];
        int[] rank=new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
        }
        
        int ex=0, cmp=n;
        for(int[] it: edges){
            if(!solve(it[0], it[1], parent, rank)){
                ex++;
            }
            else{
                cmp--;
            }
        }
        
        if(cmp-1<=ex)
            return cmp-1;
        
        return -1;
    }
}