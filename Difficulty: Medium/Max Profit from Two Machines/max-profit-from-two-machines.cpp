class Solution{
    public:
    
    int maxProfit(int x, int y, vector<int> &a, vector<int> &b){
        int n=a.size();
            
        vector<bool> visited(n, false);
        // priority_queue<pair<int, int>, vector<pair<int, int>>, less<pair<int, int>>> pqa;
        // priority_queue<pair<int, int>, vector<pair<int, int>>, less<pair<int, int>>> pqb;
        priority_queue<pair<int,int>> pqa;
        priority_queue<pair<int,int>> pqb;
        
        for(int i=0; i<n; i++){
            int diff=a[i]-b[i];
            if(diff>=0){
                pqa.push({diff, i});
            }
            else{
                pqb.push({abs(diff), i});
            }
        }
        
        int res=0;
        while(x>0 && y>0){
            if(pqa.empty() || pqb.empty())
                break;
            pair<int, int> topa=pqa.top();
            pair<int, int> topb=pqb.top();
            if(topa.first>=topb.first){
                pqa.pop();
                res += a[topa.second];
                visited[topa.second]=true;
                x--;
            }
            else{
                pqb.pop();
                res += b[topb.second];
                visited[topb.second]=true;
                y--;
            }
        }
        
        while(x>0 && !pqa.empty()){
            int idx=pqa.top().second;
            pqa.pop();
            res += a[idx];
            visited[idx]=true;
            x--;
        }
        while(y>0 && !pqb.empty()){
            int idx=pqb.top().second;
            pqb.pop();
            res += b[idx];
            visited[idx]=true;
            y--;
        }
        
        for(int i=0; i<n && x>0; i++){
            if(visited[i] == false){
                res += a[i];
                visited[i]=true;
                x--;
            }
        }
        for(int i=0; i<n && y>0; i++){
            if(visited[i] == false){
                res += b[i];
                visited[i]=true;
                y--;
            }
        }
        
        return res;
        
        

    }
};