/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

import java.util.concurrent.atomic.AtomicInteger;

class Solution{
    int solve(Node root, AtomicInteger mx){
        if(root == null)
            return Integer.MAX_VALUE;
            
        int left=solve(root.left, mx);
        int right=solve(root.right, mx);
        
        if(left != Integer.MAX_VALUE){
            mx.set(Math.max(mx.get(), root.data-left));
        }
        if(right != Integer.MAX_VALUE){
            mx.set(Math.max(mx.get(), root.data-right));
        }        

        return Math.min(root.data, Math.min(left, right));
        
    }
    
    int maxDiff(Node root){
        
        AtomicInteger mx=new AtomicInteger(Integer.MIN_VALUE);
        solve(root, mx);
        
        return mx.get();
    }
}