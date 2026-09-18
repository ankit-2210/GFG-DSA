/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution{
    void solve(Node root, ArrayList<Integer> temp){
        if(root == null)
            return;
            
        solve(root.left, temp);
        temp.add(root.data);
        solve(root.right, temp);
    }
    
    public int absDiff(Node root){
        
        ArrayList<Integer> temp=new ArrayList<>();
        solve(root, temp);
        
        int res=Integer.MAX_VALUE;
        for(int i=1; i<temp.size(); i++){
            res=Math.min(res, temp.get(i)-temp.get(i-1));
        }
        
        return res;
        
    }
}





















