class Solution{
    public:
    void solve(int idx, int open, int close, string s, int pair, string curr, set<string> &st, vector<string> &res, int n){
        if(idx>=n){
            if(open == 0 && close == 0 && pair == 0){
                if(st.find(curr) == st.end()){
                    st.insert(curr);
                    res.push_back(curr);
                }
            }
            return;
        }
        
        if(s[idx] != '(' && s[idx] != ')'){
            solve(idx+1, open, close, s, pair, curr+s[idx], st, res, n);
        }
        else{
            if(s[idx] == '('){
                if(open>0){
                    solve(idx+1, open-1, close, s, pair, curr, st, res, n);
                }
                solve(idx+1, open, close, s, pair+1, curr+s[idx], st, res, n);
            }
            else{
                if(close>0){
                    solve(idx+1, open, close-1, s, pair, curr, st, res, n);
                }
                if(pair>0){
                    solve(idx+1, open, close, s, pair-1, curr+s[idx], st, res, n);
                }
            }
        }
        
    }
    
    vector<string> validParenthesis(string &s){
        int n=s.size();
        
        int open=0, close=0;
        for(int i=0; i<n; i++){
            if(s[i] == '('){
                open++;
            }
            if(s[i] == ')'){
                if(open != 0){
                    open--;
                }
                else{
                    close++;
                }
            }
        }
        
        // cout << open << " " << close << endl;
        
        vector<string> res;
        set<string> st;
        solve(0, open, close, s, 0, "", st, res, n);
        return res; 
        
    }
};
