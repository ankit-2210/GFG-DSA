class Solution{
    public:
    int longestSubstr(string &s, int k){
        int n=s.size();
        
        int i=0, j=0;
        map<char, int> mp;
        int res=0;
        int mx=0;
        while(j<n){
            mp[s[j]]++;
            mx=max(mx, mp[s[j]]);
            while(mx+k<j-i+1){
                mp[s[i]]--;
                if(mp[s[i]] == 0){
                    mp.erase(s[i]);
                }
                i++;
            }
            
            res=max(res, j-i+1);
            j++;
        }
        
        return res;
    }
};