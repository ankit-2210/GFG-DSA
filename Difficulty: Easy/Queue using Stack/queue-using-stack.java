class myQueue{
    Stack<Integer> st=new Stack<>();
   
    void enqueue(int x){
        st.push(x);
        
    }

    void dequeue(){
        if(st.isEmpty())
            return;
        
        int x=st.pop();
        if(st.isEmpty())
            return;
            
        dequeue();
        
        st.push(x);
    }

    int front(){
        if(st.isEmpty())
            return -1;
            
        int x=st.pop();
        if(st.isEmpty()){
            st.push(x);
            return x;
        }
        
        int item=front();
        
        st.push(x);
        return item;
    }

    int size(){
        return st.size();
    }
    
}
