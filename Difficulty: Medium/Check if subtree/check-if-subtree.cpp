/*
Definition for Node
struct Node
{
    int data;
    Node* left;
    Node* right;

    Node(int x){
        data = x;
        left = right = nullptr;
    }
};
*/

class Solution{
    public:
    bool solve(Node *root1, Node *root2){
        if(root1 == NULL && root2 == NULL)
            return true;
            
        if((root1 != NULL && root2 == NULL) || (root1 == NULL && root2 != NULL))
            return false;
        
        if(root1->data != root2->data)
            return false;
            
        return (solve(root1->left, root2->left) && solve(root1->right, root2->right));
    }
    
    bool isSubTree(Node *root1, Node *root2){
        if(root1 == NULL && root2 == NULL)
            return true;
        if(root1 == NULL || root2 == NULL)
            return false;
        
        if(solve(root1, root2)) 
            return true;
        
        return (isSubTree(root1->left, root2) || isSubTree(root1->right, root2));
    
    }
};




























