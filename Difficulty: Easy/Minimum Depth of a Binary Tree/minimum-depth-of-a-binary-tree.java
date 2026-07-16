/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution{
    int solve(Node root){
        if(root == null)
            return 0;
        
        int l=solve(root.left);
        int r=solve(root.right);
        
        if(l == 0 || r == 0)
            return 1+l+r;
        return 1+Math.min(l, r);
    }
    
    int minDepth(Node root){
        
        return solve(root);
    
        
    }
}


























