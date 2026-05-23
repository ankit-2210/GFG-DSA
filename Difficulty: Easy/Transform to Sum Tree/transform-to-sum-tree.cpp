/* Structure for Tree Node
class Node {
public:
    int data;
    Node* left;
    Node* right;

    Node(int val) {
        data = val;
        left = nullptr;
        right = nullptr;
    }
};
*/

class Solution{
    public:
    int solve(Node *root){
        if(root == NULL)
            return 0;
            
        if(root->left == NULL && root->right == NULL){
            int t=root->data;
            root->data=0;
            return t;
        }
        
        int l=solve(root->left);
        int r=solve(root->right);
        
        int t=root->data;
        root->data=l+r;
        
        return t+root->data;
    }
    
    void toSumTree(Node *root){
        
        solve(root);    
        
        
    }
};



























