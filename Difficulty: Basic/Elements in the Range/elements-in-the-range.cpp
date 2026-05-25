class Solution{
    public:
    bool checkElements(int start, int end, vector<int> &arr){
        int n=arr.size();
        
        map<int, int> mp;
        for(int i=0; i<n; i++){
            mp[arr[i]]++;
        }
        
        for(int i=start; i<=end; i++){
            if(mp.find(i) == mp.end())
                return false;
        }
        
        return true;
    
        
    }
};
