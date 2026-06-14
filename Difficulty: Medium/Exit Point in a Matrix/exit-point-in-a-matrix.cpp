class Solution{
    public:
    vector<int> exitPoint(vector<vector<int>> &mat){
        int n=mat.size();
        int m=mat[0].size();
        
        int d=0;
        int row=0, col=0;
        while(row>=0 && row<n && col>=0 && col<m){
            if(mat[row][col] == 1){
                mat[row][col]=0;
                d=(d+1)%4;
            }
            
            if(d == 0){
                col++;
            }
            else if(d == 1){
                row++;
            }
            else if(d == 2){
                col--;
            }
            else{
                row--;
            }
        }
        
        if(d == 0){
            col--;
        }
        else if(d == 1){
            row--;
        }
        else if(d == 2){
            col++;
        }
        else{
            row++;
        }
        
        return {row, col};
        
        
    }
};