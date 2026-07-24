import java.util.concurrent.atomic.AtomicInteger;

/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
}*/
class Solution{
    void solve(Node root, int parent, int len, AtomicInteger res){
        if(root == null)
            return;
            
        if(root.data == parent+1){
            len++;
        }
        else{
            len=1;
        }
        
        res.set(Math.max(res.get(), len));
        solve(root.left, root.data, len, res);
        solve(root.right, root.data, len, res);
        
    }
    
    public int longestConsecutive(Node root){
    
        AtomicInteger res=new AtomicInteger(0);
        solve(root, root.data-1, 0, res);
    
        if(res.get() == 1)
            return -1;
            
        return res.get();
    }
}