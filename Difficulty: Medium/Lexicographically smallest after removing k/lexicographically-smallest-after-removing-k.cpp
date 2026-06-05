class Solution{
    public:
    string lexicographicallySmallest(string &s, int k){
        int n=s.size();
        
        k=((n&(n-1)) == 0)?k>>1:k<<1;
        if(k>=n)
            return "-1";
            
        stack<char> st;
        for(int i=0; i<n; i++){
            if(st.empty()){
                st.push(s[i]);
            }
            else{
                while(!st.empty() && k>0 && s[i]<st.top()){
                    k--;
                    st.pop();
                }
                
                st.push(s[i]);
            }
        }
        
        while(!st.empty() && k>0){
            st.pop();
            k--;
        }
        
        string str="";
        while(!st.empty()){
            str += st.top();
            st.pop();
        }
        
        reverse(str.begin(), str.end());
        return str;
            
        
    }
};