class Solution{
    public:
    double solve(vector<vector<double>> mat, int n){
        double det=1.0;
        for(int i=0; i<n; i++){
            int pivot=i;
            for(int j=i+1; j<n; j++){
                if(abs(mat[j][i])>abs(mat[pivot][i])){
                    pivot=j;
                }
            }
            
            if(mat[pivot][i] == 0)
                return 0;
                
            if(i != pivot){
                swap(mat[i], mat[pivot]);
                det *= -1;
            }
            
            det *= mat[i][i];
            for(int j=i+1; j<n; j++){
                double factor=mat[j][i]/mat[i][i];
                for(int k=i; k<n; k++){
                    mat[j][k] -= (factor*mat[i][k]);
                }
            }
        }
        
        return round(det);
    
    }
    
    int countSpanTree(int n, vector<vector<int>> &e){
        
        vector<vector<double>> l(n, vector<double> (n, 0));
        for(auto it: e){
            l[it[0]][it[0]]++;
            l[it[1]][it[1]]++;
            l[it[0]][it[1]]--;
            l[it[1]][it[0]]--;
        }
        
        vector<vector<double>> minor(n-1, vector<double> (n-1));
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-1; j++){
                minor[i][j]=l[i][j];
            }
        }
        
        return (int)round(solve(minor, n-1));
        
    }
};