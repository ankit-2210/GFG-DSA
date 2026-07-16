class Solution{
    public String getLongestPal(String s){
        int n=s.length();
        
        boolean[][] dp=new boolean[n][n];
        // for(boolean row[]: dp){
            // Arrays.fill(row);
        // }
        
        int res=1;
        int first=0;
        for(int g=0; g<n; g++){
            for(int i=0, j=g; j<n; i++, j++){
                if(g == 0){
                    dp[i][j]=true;
                }
                else if(g == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j]=true;
                        if(res<2){
                            res=2;
                            first=i;
                        }
                    }
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j]=true;
                        if(g+1>res){
                            res=g+1;
                            first=i;
                        }
                    }
                }
            }
        }
        
        return s.substring(first, first+res);
        
        
    }
}