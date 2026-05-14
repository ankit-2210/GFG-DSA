class Solution{
    public:
    void solve(vector<int> &b, vector<int> &lps, int n){
        
        lps[0]=0;
        int len=0, i=1;
        while(i<n){
            if(b[len] == b[i]){
                lps[i]=++len;
                i++;
            }
            else{
                if(len != 0){
                    len=lps[len-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
            
        }
    }
    
    vector<int> search(vector<int> &a, vector<int> &b){
        int n=a.size();
        int m=b.size();
        
        vector<int> lps(m);
        solve(b, lps, m);
        
        vector<int> res;
        int i=0, j=0;
        while(i<n){
            if(a[i] == b[j]){
                i++;
                j++;
            }
            if(j == m){
                res.push_back(i-j);
                j=lps[j-1];
            }
            else if(i<n && a[i] != b[j]){
                if(j != 0){
                    j=lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
            
        return res;
        
        
    }
};