class Solution{
    public:
    int findPosition(int n){
        int i=-1;
        int c=0;
        while(n>0){
            c++;
            int rem=n%2;
            if(i == -1 && rem == 1){
                i=c;
            }
            else if(rem == 1){
                return -1;
            }
            n>>=1;
        }
        
        return i;
    
        
    }
};