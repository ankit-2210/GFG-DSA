class Solution:
    def findMax(self, n, a, b, k):
        m=len(a)
        
        mp={}
        for i in range(m):
            mp[a[i]] = mp.get(a[i], 0)+k[i]
            mp[b[i]+1] = mp.get(b[i]+1, 0)-k[i]
        
        sum=0
        res=0
        for key in sorted(mp):
            sum += mp[key]
            res=max(res, sum)
        
        return res
        
        
        