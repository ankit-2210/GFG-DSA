class Solution{
    List<Integer> makeBeautiful(int[] arr){
        int n=arr.length;
            
        Stack<Integer> st=new Stack<>();
        for(int i=0; i<n; i++){
            if(st.isEmpty()){
                st.push(arr[i]);
            }
            else{
                if(!st.isEmpty() && ((st.peek()>=0 && arr[i]<0) || (st.peek()<0 && arr[i]>=0))){
                    st.pop();
                }
                else{
                    st.push(arr[i]);
                }
            }
        }
        
        ArrayList<Integer> res=new ArrayList<>();
        while(!st.isEmpty()){
            res.add(st.peek());
            st.pop();
        }
        
        Collections.reverse(res);
        return res;
        
    }
}