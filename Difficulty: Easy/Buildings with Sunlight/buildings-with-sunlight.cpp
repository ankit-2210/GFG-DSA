class Solution{
    public:
    int visibleBuildings(vector<int> &arr){
        int n=arr.size();
        
        stack<int> st;
        for(int i=0; i<n; i++){
            if(st.empty()){
                st.push(arr[i]);
            }   
            else{
                if(!st.empty() && arr[i]>=st.top()){
                    st.push(arr[i]);
                }
            }
        }
            
        return st.size();
        
    }
};