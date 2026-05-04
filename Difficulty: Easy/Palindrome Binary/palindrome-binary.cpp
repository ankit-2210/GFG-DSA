#define ll long long int

class Solution{
    public:
    int isPallindrome(long long int n){
        
        ll org=n;
        ll rev=0;
        while(n>0){
            rev=(rev<<=1)|(n&1);
            n>>=1;
        }
        
        if(rev == org)
            return true;
        return false;
    }
};