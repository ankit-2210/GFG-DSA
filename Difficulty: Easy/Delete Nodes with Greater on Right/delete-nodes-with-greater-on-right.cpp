/* Structure of a Linked List node
class Node {
  public:
    int data;
    Node* next;

    Node(int x) {
        data = x;
        next = nullptr;
    }
};
*/
class Solution{
    public:
    Node *compute(Node *head){
        
        stack<Node *> st;
        Node *node=head;
        while(node != NULL){
            
            while(!st.empty() && st.top()->data<node->data){
                st.pop();
            }
            
            if(!st.empty()){
                st.top()->next=node;
            }
            
            st.push(node);
            node=node->next;
        }
        
        while(!st.empty()){
            head=st.top();
            st.pop();
        }
        
        return head;
    }
};





























