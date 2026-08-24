class Solution{
    static final int mod=1000000007;
    long power(long a, long b){
        long res=1;
        while(b>0){
            if((b&1) == 1){
                res=(res*a)%mod;
            }
            a=(a*a)%mod;
            b>>=1;
        }
        
        return res;
    }
    
    
    public int prefixStrings(int n){
        
        long[] fact=new long[2*n+1];
        fact[0]=1;
        for(int i=1; i<=2*n; i++){
            fact[i]=(fact[i-1]*i)%mod;
        }
        
        long num=fact[2*n];
        long den=(fact[n]*fact[n])%mod;
        den=(den*(n+1))%mod;
        
        long inverse = power(den, mod-2);
        return (int)((num*inverse)%mod);
        
        
        
    }
}