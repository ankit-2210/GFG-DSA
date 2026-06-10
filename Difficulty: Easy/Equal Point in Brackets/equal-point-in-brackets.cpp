class Solution{
    public:
    int findIndex(string &s){
        int n=s.size();
        
        int open=0, close=0;
        for(int i=0; i<n; i++){
            if(s[i] == ')'){
                close++;
            }
        }  
        
        for(int i=0; i<n; i++){
            if(s[i] == '('){
                open++;
            }
            else{
                close--;
            }
            
            if(open == close)
                return i+1;
        }
        
        return 0;
        
    }
};