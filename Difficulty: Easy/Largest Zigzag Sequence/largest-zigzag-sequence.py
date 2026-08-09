class Solution:
    def solve(self, i, j, mat, dp, n, m):
        if i>=n:
            return 0
        
        if dp[i][j] != -1:
            return dp[i][j]
            
        temp=0;
        for k in range(m):
            if k != j:
                temp=max(temp, mat[i][j]+self.solve(i+1, k, mat, dp, n, m))
            
        
        dp[i][j]=temp
        return dp[i][j]
    
    def zigzagSequence(self, mat):
        n=len(mat)
        m=len(mat[0])
        
        if n == 1 and m == 1:
            return mat[0][0]
        
        
        dp=[[-1]*m for _ in range(n)]
        
        res=0
        for j in range(m):
            res=max(res, self.solve(0, j, mat, dp, n, m))
        
        return res
        
        
        
        