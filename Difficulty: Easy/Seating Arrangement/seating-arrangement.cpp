class Solution{
    public:
    bool canSeatAllPeople(int k, vector<int> &s){
        int n=s.size();
        
        if(k == 0)
            return true;
            
        for(int i=0; i<n; i++){
            if(s[i] == 1)
                continue;
                
            int left=(i==0 || s[i-1] == 0);
            int right=(i==n-1 || s[i+1] == 0);
            
            if(left && right){
                s[i]=1;
                k--;
            }
            
            if(k == 0)
                return true;
        }
        
        if(k>0)
            return false;
        
        return true;
    }
};