/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution{
    void solve(Node root, int count, ArrayList<Integer> temp){
        if(root == null)
            return;
            
        if(root.left == null && root.right == null){
            temp.add(count+1);
            return;
        }
        
        solve(root.left, count+1, temp);
        solve(root.right, count+1, temp);
        
    }
    
    public int getCount(Node root, int k){
        
        ArrayList<Integer> temp=new ArrayList<>();
        solve(root, 0, temp);
        
        Collections.sort(temp);
        
        int res=0;
        int cost=0;
        for(int d: temp){
            if(cost+d>k)
                break;
                
            cost += d;
            res++;
        }
        
        return res;
    
        
    }
}





























