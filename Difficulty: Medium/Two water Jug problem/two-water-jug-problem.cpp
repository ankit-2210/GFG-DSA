class Solution{
    public:
    int solve(int fromCap, int toCap, int d){
        int from=fromCap;
        int to=0;
        int res=1;
        
        while(from != d && to != d){
            int temp=min(from, toCap-to);
            from -= temp;
            to += temp;
            res++;
            
            if(from == d || to == d)
                break;
            if(from == 0){
                from=fromCap;
                res++;
            }
            if(to == toCap){
                to=0;
                res++;
            }
        }
        
        return res;
    }
    
    int minSteps(int m, int n, int d){
        if(d>max(m, n)) 
            return -1;
        if(d%__gcd(m, n) != 0) 
            return -1;
        
        return min(solve(n, m, d), solve(m, n, d));
        
       
    }
};

























