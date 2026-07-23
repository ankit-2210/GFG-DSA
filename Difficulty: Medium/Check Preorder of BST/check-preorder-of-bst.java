class Solution{
    public boolean canRepresentBST(List<Integer> arr){
        int n=arr.size();
        
        int lower=Integer.MIN_VALUE;
        Stack<Integer> st=new Stack<>();
        
        for(int val: arr){
            if(val<lower)
                return false;
            
            while(!st.isEmpty() && val>st.peek()){
                lower=st.peek();
                st.pop();
            }
            
            
            st.push(val);
            
        }
        
        return true;
        
    }
}