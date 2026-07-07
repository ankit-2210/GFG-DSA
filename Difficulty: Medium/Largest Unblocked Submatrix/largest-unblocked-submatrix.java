class Solution{
    public int largestArea(int n, int m, int k, int[][] arr){
        
        int[] row=new int[n];
        Arrays.fill(row, 1);
        
        int[] col=new int[m];
        Arrays.fill(col, 1);
        
        for(int[] it: arr){
            row[it[0]-1]=0;
            col[it[1]-1]=0;
        }
        
        int mxr=0;
        int cr=0;
        for(int it: row){
            if(it == 1){
                cr++;
                mxr=Math.max(mxr, cr);
            }
            else{
                cr=0;
            }
        }
        int mxc=0;
        int cc=0;
        for(int it: col){
            if(it == 1){
                cc++;
                mxc=Math.max(mxc, cc);
            }
            else{
                cc=0;
            }
        }
        
        return mxr*mxc;
        
        
    }
}