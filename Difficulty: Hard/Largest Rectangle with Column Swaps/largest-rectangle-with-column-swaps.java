class Solution{
    public int maxArea(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;
        
        int res=Integer.MIN_VALUE;
        int[] height=new int[m];
        for(int i=0; i<n; i++){
            int[] count=new int[n+1];
            for(int j=0; j<m; j++){
                if(mat[i][j] == 1){
                    height[j]++;
                }
                else{
                    height[j]=0;
                }
                
                count[height[j]]++;
            }
            
            int w=0;
            for(int h=n; h>=1; h--){
                w += count[h];
                res=Math.max(res, w*h);
            }
            
        }
        
        return res;
        
        
    }
}