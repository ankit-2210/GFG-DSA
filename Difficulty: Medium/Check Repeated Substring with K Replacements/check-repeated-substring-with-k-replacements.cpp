class Solution{
    public:
    bool kSubstr(string &s, int k){
        int n=s.size();
        
        unordered_map<string, int> mp;
        for(int i=0; i<n; i+=k){
            string str=s.substr(i, k);
            mp[str]++;
        }
        
        if(mp.size() == 1)
            return true;
        if(mp.size()>2)
            return false;
            
        int c=0;
        for(auto it: mp){
            if(it.second>1)
                c++;
        }
        
        if(c>1)
            return false;
            
        return true;
        
    }
};