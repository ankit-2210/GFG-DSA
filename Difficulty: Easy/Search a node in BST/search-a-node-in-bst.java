/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution{
    boolean solve(Node root, int key){
        if(root == null)
            return false;
            
        if(root.data == key)
            return true;
            
        boolean l=solve(root.left, key);
        boolean r=solve(root.right, key);
        
        return l||r;
    }
    
    public boolean search(Node root, int key){
        
        return solve(root, key);
        
        
    }
}




























