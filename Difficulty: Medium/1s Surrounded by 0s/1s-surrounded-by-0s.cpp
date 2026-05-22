class Solution{
  public:
    int cntOnes(vector<vector<int>> &g){
        int n=g.size();
        int m=g[0].size();
        
        vector<vector<bool>> visited(n, vector<bool> (m, false));
        queue<pair<int, int>> q;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(g[i][j] == 1){
                        visited[i][j]=true;
                        q.push({i, j});
                    }
                }
            }
        }
        
        while(!q.empty()){
            int i=q.front().first;
            int j=q.front().second;
            q.pop();
            
            if(i-1>=0 && g[i-1][j] == 1 && visited[i-1][j] == false){
                visited[i-1][j]=true;
                q.push({i-1, j});
            }
            if(i+1<n && g[i+1][j] == 1 && visited[i+1][j] == false){
                visited[i+1][j]=true;
                q.push({i+1, j});
            }
            if(j-1>=0 && g[i][j-1] == 1 && visited[i][j-1] == false){
                visited[i][j-1]=true;
                q.push({i, j-1});
            }
            if(j+1<m && g[i][j+1] == 1 && visited[i][j+1] == false){
                visited[i][j+1]=true;
                q.push({i, j+1});
            }
        }
        
        int res=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(g[i][j] == 1 && visited[i][j] == false)
                    res++;
            }
        }
        
        return res;
        
        
    }
};