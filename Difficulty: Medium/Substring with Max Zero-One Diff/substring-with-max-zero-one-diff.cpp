class Solution{
    public:
    int maxSubstring(string &s){
        int n=s.size();
        
        int mx=-1;
        int curr=0;
        for(int i=0; i<n; i++){
            curr += (s[i]-'0' == 0)?1:-1;
            mx=max(mx, curr);
            if(curr<0)
                curr=0;
        }
        
        return mx;
        
        
    }
};