class Solution{
    public:
    int findCoverage(vector<vector<int>> &mat){
        int n=mat.size();
        int m=mat[0].size();
        
        int res=0;
        for(int i=0; i<n; i++){
            bool one=false;
            for(int j=0; j<m; j++){
                if(mat[i][j] == 1){
                    one=true;
                }
                else if(one){
                    res++;
                }
            }
            one=false;
            for(int j=m-1; j>=0; j--){
                if(mat[i][j] == 1){
                    one=true;
                }
                else if(one){
                    res++;
                }
            }
        }
        
        for(int j=0; j<m; j++){
            bool one=false;
            for(int i=0; i<n; i++){
                if(mat[i][j] == 1){
                    one=true;
                }
                else if(one){
                    res++;
                }
            }
            one=false;
            for(int i=n-1; i>=0; i--){
                if(mat[i][j] == 1){
                    one=true;
                }
                else if(one){
                    res++;
                }
            }
        }
        
        return res;
        
        
        
    }
};
