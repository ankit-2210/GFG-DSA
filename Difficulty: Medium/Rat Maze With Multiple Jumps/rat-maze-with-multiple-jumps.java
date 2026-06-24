class Solution{
      boolean solve(int i, int j, int[][] mat, int[][] path, int n, int m){
        if(i == n-1 && j == n-1){
            path[i][j]=1;
            return true;
        }
        
        if(i>=n || j>=m)
            return false;
            
        if(mat[i][j] == 0)
            return false;
            
        path[i][j]=1;    
        int maxjump=mat[i][j];
        for(int jump=1; jump<=maxjump; jump++){
            if(j+jump<m && solve(i, j+jump, mat, path, n, m))
                return true;
            if(i+jump<n && solve(i+jump, j, mat, path, n, m))
                return true;
        }
        
        path[i][j]=0;
        mat[i][j]=0;
        return false;
    }
    
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        
        if (mat[0][0] == 0)
            return new ArrayList<ArrayList<Integer>>() {{
                add(new ArrayList<>(Arrays.asList(-1)));
                
            }};
        
        int[][] path=new int[n][m];
        if(!solve(0, 0, mat, path, n, m))
            return new ArrayList<ArrayList<Integer>>() {{
                add(new ArrayList<>(Arrays.asList(-1)));
                
            }};
            
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        for(int i=0; i<n; i++){
            ArrayList<Integer> row=new ArrayList<>();
            for(int j=0; j<m; j++){
                row.add(path[i][j]);
            }
            res.add(row);
        }
            
        return res;
        
    }
}