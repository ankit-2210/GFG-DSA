class Solution{
    public:
    vector<int> reducePairs(vector<int> &arr){
        int n=arr.size();
        
        stack<int> st;
        for(int i=0; i<n; i++){
            bool flag=true;
            
            while(!st.empty() && ((st.top()<0 && arr[i]>0) || (st.top()>0 && arr[i]<0))){
                if(abs(st.top()) == abs(arr[i])){
                    st.pop();
                    flag=false;
                    break;
                }
                else if(abs(st.top())>abs(arr[i])){
                    flag=false;
                    break;
                }
                else{
                    st.pop();
                }
            }
            
            if(flag){
                st.push(arr[i]);
            }
        }
        
        vector<int> res;
        while(!st.empty()){
            res.push_back(st.top());
            st.pop();
        }
        
        reverse(res.begin(), res.end());
        return res;
        
    }
};