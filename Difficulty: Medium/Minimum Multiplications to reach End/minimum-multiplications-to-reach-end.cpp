class Solution{
    public:
    int minSteps(vector<int> &arr, int start, int end){
        int n=arr.size();
        
        vector<int> dist(1000, INT_MAX);
        queue<pair<int, int>> q;
        q.push({start, 0});
        dist[start]=0;
        while(!q.empty()){
            int num=q.front().first;
            int step=q.front().second;
            q.pop();
            
            if(num == end)
                return step;
            
            for(auto it: arr){
                int next=(it*num)%1000;
                if(1+step<dist[next]){
                    dist[next]=1+step;
                    q.push({next, dist[next]});
                }
            }
        }
        
        return -1;
        
    }
};