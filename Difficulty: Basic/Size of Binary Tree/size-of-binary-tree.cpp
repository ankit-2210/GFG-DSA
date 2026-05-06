/*
Definition for Node
struct Node {
    int data;
    struct Node* left;
    struct Node* right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};
*/
class Solution {
  public:
    int solve(Node *root){
        if(root == NULL)
            return 0;
        int left=solve(root->left);
        int right=solve(root->right);
        return 1+left+right;
    }
    
    int getSize(Node *root){
        return solve(root);
        
        
    }
};