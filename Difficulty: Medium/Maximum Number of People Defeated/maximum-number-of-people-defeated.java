class Solution{
    int maxPeopleDefeated(int p){
    
    
        int i=1;
        int res=0;
        while(i*i<=p){
            p -= (i*i);
            res++;
            i++;
        }
    
        return res;
        
    }
};