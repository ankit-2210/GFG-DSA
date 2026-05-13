class Solution{
    public:
    void solve(int node, vector<vector<int>> &adj, vector<bool> &visited, int n){
        visited[node]=true;
        for(auto it: adj[node]){
            if(visited[it] == false){
                solve(it, adj, visited, n);
            }
        }
        return;
    }
    
    int findMotherVertex(int v, vector<vector<int>> &e){
    
        vector<vector<int>> adj(v);
        for(auto it: e){
            adj[it[0]].push_back(it[1]);
            // adj[it[1]].push_back(it[0]);
        }
        
        int c;
        vector<bool> visited(v, false);
        for(int i=0; i<v; i++){
            if(visited[i] == false){
                solve(i, adj, visited, v);
                c=i;
            }
        }
        
        fill(visited.begin(), visited.end(), false);
        solve(c, adj, visited, v);
        for(int i=0; i<v; i++){
            if(visited[i] == false)
                return -1;
        }
        
        return c;
        
    }
};