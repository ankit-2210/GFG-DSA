class Solution {
  public:
    int lower(vector<int> &t, int x){
        int low=0, high=t.size();
        while(low<high){
            int mid=low+(high-low)/2;
            if(t[mid]<x){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
    int upper(vector<int> &t, int x){
        int low=0, high=t.size();
        while(low<high){
            int mid=low+(high-low)/2;
            if(t[mid]<=x){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
  
    vector<int> freqInRange(vector<int> &arr, vector<vector<int>> &q){
        int n=arr.size();
        int m=q.size();
        
        vector<int> res(m);
        map<int, vector<int>> mp;
        for(int i=0; i<n; i++){
            mp[arr[i]].push_back(i);
        }
        
        for(int i=0; i<m; i++){
            int l=q[i][0];
            int r=q[i][1];
            int x=q[i][2];
            
            if(mp.find(x) == mp.end()){
                res[i]=0;
            }
            else{
                int lb=lower(mp[x], l);
                int rb=upper(mp[x], r);
                res[i]=rb-lb;
            }
        }
        
        return res;
        
        
        
    }
};