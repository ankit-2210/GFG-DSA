class Solution{
    public:
    string chooseSwap(string &s){
        int n=s.size();
            
        map<char, int> mp;
        for(int i=0; i<n; i++){
            if(mp.find(s[i]) == mp.end()){
                mp[s[i]]=i;
            }
        }
        
        char x, y;
        int pos=-1;
        for(int i=0; i<n; i++){
            char curr=s[i];
            for(char ch=0; ch<curr; ch++){
                if(mp[ch]>i){
                    pos=i;
                    x=s[i];
                    y=ch;
                    break;
                }
            }
            if(pos != -1)
                break;
        }
        
        if(pos == -1)
            return s;
        
        for(int i=0; i<n; i++){
            if(s[i] == x){
                s[i]=y;
            }
            else if(s[i] == y){
                s[i]=x;
            }
        }
        
        return s;
        
    }
};
