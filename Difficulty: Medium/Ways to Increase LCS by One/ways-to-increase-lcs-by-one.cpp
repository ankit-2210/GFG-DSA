class Solution{
    public:
    int waysToIncreaseLCSBy1(string &s1, string &s2){
        int n=s1.size();
        int m=s2.size();
        
        
        vector<vector<int>> pos(26);
        for(int i=0; i<m; i++){
            pos[s2[i]-'a'].push_back(i+1);
        }
        
        vector<vector<int>> lcsl(n+2, vector<int> (m+2, 0));
        vector<vector<int>> lcsr(n+2, vector<int> (m+2, 0));
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1[i-1] == s2[j-1]){
                    lcsl[i][j]=1+lcsl[i-1][j-1];
                }
                else{
                    lcsl[i][j]=max(lcsl[i-1][j], lcsl[i][j-1]);
                }
            }
        }
        
        for(int i=n; i>=1; i--){
            for(int j=m; j>=1; j--){
                if(s1[i-1] == s2[j-1]){
                    lcsr[i][j]=1+lcsr[i+1][j+1];
                }
                else{
                    lcsr[i][j]=max(lcsr[i+1][j], lcsr[i][j+1]);
                }
            }
        }
        
        
        int base=lcsl[n][m];
        int res=0;
        for(int i=0; i<=n; i++){
            for(char ch='a'; ch<='z'; ch++){
                vector<int> &pss=pos[ch-'a'];
                
                for(int j=0; j<(int)pss.size(); j++){
                    int p1=pss[j];
                    if(lcsl[i][p1-1]+lcsr[i+1][p1+1] == base){
                        res++;
                        break;
                    }
                }
                
            }
        }
        
        return res;
        

        
    }
};
