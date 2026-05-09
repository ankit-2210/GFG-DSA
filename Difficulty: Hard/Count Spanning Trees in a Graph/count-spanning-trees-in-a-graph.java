class Solution{
    double solve(double[][] mat, int n){
        double det=1.0;
        for(int i=0; i<n; i++){
            int pivot=i;
            for(int j=i+1; j<n; j++){
                if(Math.abs(mat[j][i])>Math.abs(mat[pivot][i])){
                    pivot=j;
                }
            }
            
            if(mat[pivot][i] == 0)
                return 0;
                
            if(i != pivot){
                double[] temp=mat[i];
                mat[i]=mat[pivot];
                mat[pivot]=temp;
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
        
        return Math.round(det);
    
    }
    
    public int countSpanTree(int n, int[][] e){
        double[][] l=new double[n][n];
        
        for(int[] it: e){
            l[it[0]][it[0]]++;
            l[it[1]][it[1]]++;
            l[it[0]][it[1]]--;
            l[it[1]][it[0]]--;
        }
        
        double[][] minor=new double[n-1][n-1];
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-1; j++){
                minor[i][j]=l[i][j];
            }
        }
        
        return (int)Math.round(solve(minor, n-1));
        
    }
}